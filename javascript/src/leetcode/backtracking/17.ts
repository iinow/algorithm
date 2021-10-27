const phone = {
  2: ['a', 'b', 'c'],
  3: ['d', 'e', 'f'],
  4: ['g', 'h', 'i'],
  5: ['j', 'k', 'l'],
  6: ['m', 'n', 'o'],
  7: ['p', 'q', 'r', 's'],
  8: ['t', 'u', 'v'],
  9: ['w', 'x', 'y', 'z'],
}

function letterCombinations(digits: string): string[] {
  if (!digits) {
    return []
  }

  const root = digits
    .split('')
    .map((v) => Number(v))
    .map((v) => phone[v])

  console.log(root)
  if (root.length === 1) {
    return root[0]
  }

  const res: string[] = []

  const dfs = (i: number, acc: string) => {
    if (root.length === i) {
      return res.push(acc)
    }

    const values: string[] = root[i]
    values.forEach((v) => {
      dfs(i + 1, acc + v)
    })
  }

  dfs(0, '')

  return res
}

console.log(letterCombinations('2344'))
