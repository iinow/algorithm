function exist(board: string[][], word: string): boolean {
  const points = new Set<string>()
  const words = word.split('')
  let res = false
  const recursive = (
    values: string[] = [],
    wordIndex = 0,
    rowIndex = 0,
    columnIndex = 0
  ) => {
    if (values.join('') === word) {
      res = true
      return
    }

    if (rowIndex < 0 || rowIndex === board.length) {
      return
    }

    if (columnIndex < 0 || columnIndex === board[0].length) {
      return
    }

    const point = `${rowIndex}|${columnIndex}`
    if (points.has(point)) {
      return
    }

    const character = board[rowIndex][columnIndex]
    if (character === words[wordIndex]) {
      values.push(character)
      points.add(point)
      recursive(values, wordIndex + 1, rowIndex - 1, columnIndex)
      recursive(values, wordIndex + 1, rowIndex + 1, columnIndex)
      recursive(values, wordIndex + 1, rowIndex, columnIndex - 1)
      recursive(values, wordIndex + 1, rowIndex, columnIndex + 1)
      values.pop()
      points.delete(point)
      return
    }
  }

  for (let i = 0; i < board.length; i++) {
    for (let j = 0; j < board[i].length; j++) {
      recursive([], 0, i, j)
    }
  }
  return res
}

console.log(exist([['b'], ['a'], ['b'], ['b'], ['a']], 'baa'))
/**
 * b
 * a
 * b
 * b
 * a
 */
