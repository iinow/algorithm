function combinationSum3(k: number, n: number): number[][] {
  if (n > 46) {
    return []
  }
  const numbers = [...Array(9).keys()].map((v) => v + 1)
  const temp = new Set<string>()
  const res: number[][] = []
  const recursive = (
    copyNumbers: number[] = numbers,
    values: number[] = []
  ) => {
    if (values.length > k) {
      return
    }
    if (values.length === k && values.reduce((a, b) => a + b) === n) {
      values.sort((a, b) => {
        if (a > b) {
          return 1
        } else if (a < b) {
          return -1
        }
        return 0
      })
      if (temp.has(values.join(','))) {
        return
      }
      temp.add(values.join(','))
      res.push([...values])
      return
    }

    if (values.length !== 0) {
      if (values.reduce((a, b) => a + b) > n || values.length > k) {
        return
      }
    }

    for (let i = 0; i < copyNumbers.length; i++) {
      const value = copyNumbers[i]
      values.push(value)
      recursive(
        copyNumbers.filter((_, index) => index > i),
        values
      )
      values.pop()
    }
  }

  recursive()
  return res
}

console.log(combinationSum3(3, 15))
