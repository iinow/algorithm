function permuteUnique(nums: number[]): number[][] {
  const res: number[][] = []
  const temp = new Set<string>()

  const recursive = (values: number[], cnums: number[]) => {
    if (values.length === nums.length) {
      if (temp.has(values.join(''))) {
        return
      }
      res.push([...values])
      temp.add(values.join(''))
      return
    }

    for (let i = 0; i < cnums.length; i++) {
      values.push(cnums[i])
      recursive(
        values,
        cnums.filter((_, i2) => i2 !== i)
      )
      values.pop()
    }
  }

  recursive([], nums)
  return res
}

console.log(permuteUnique([1, 1, 2]))
