function permute(nums: number[]): number[][] {
  const res: number[][] = []

  const recursive = (values: number[], cnums: number[]) => {
    if (values.length === nums.length) {
      res.push([...values])
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

console.log(permute([1, 2, 3]))
