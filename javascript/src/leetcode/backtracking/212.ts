class TrieNode {
  children = new Map<string, TrieNode>()
  end: boolean

  constructor() {
    this.end = false
  }

  insert(word: string) {
    if (!word.length) {
      this.end = true
      return
    }

    if (!this.children.has(word.charAt(0))) {
      this.children.set(word.charAt(0), new TrieNode())
    }

    return (<TrieNode>this.children.get(word.charAt(0))).insert(
      word.substr(1, word.length)
    )
  }
}

function findWords(board: string[][], words: string[]): string[] {
  const res: string[] = []
  const node = new TrieNode()
  words.forEach((word) => node.insert(word))

  const recursive = (
    rowIndex: number,
    columnIndex: number,
    node: TrieNode,
    word = ''
  ) => {
    if (rowIndex < 0 || rowIndex >= board.length) {
      return
    }

    if (columnIndex < 0 || columnIndex >= board[0].length) {
      return
    }

    const char = board[rowIndex][columnIndex]
    const child = node.children.get(char)
    if (!child) {
      return
    }

    if (child.end) {
      child.end = false
      res.push(word + char)
    }

    board[rowIndex][columnIndex] = '*'

    recursive(rowIndex + 1, columnIndex, child, word + char)
    recursive(rowIndex - 1, columnIndex, child, word + char)
    recursive(rowIndex, columnIndex + 1, child, word + char)
    recursive(rowIndex, columnIndex - 1, child, word + char)

    board[rowIndex][columnIndex] = char
  }

  for (let rowIndex = 0; rowIndex < board.length; rowIndex++) {
    for (let columnIndex = 0; columnIndex < board[0].length; columnIndex++) {
      recursive(rowIndex, columnIndex, node)
    }
  }

  return res
}

const result = findWords([['a', 'a']], ['aaa'])

console.log(result)
