function subsetsWithDup(nums: number[]): number[][] {
  nums.sort()
  const temp = new Set<string>()
  const res: number[][] = []
  const recursive = (values: number[] = [], copyNums: number[] = nums) => {
    if (temp.has(values.join(','))) {
      return
    }
    res.push([...values])
    temp.add(values.join(','))
    if (copyNums.length === 0) {
      return
    }
    for (let i = 0; i < copyNums.length; i++) {
      values.push(copyNums[i])
      recursive(
        values,
        copyNums.filter((_, index) => index > i)
      )
      values.pop()
    }
  }

  recursive()
  return res
}

console.log(subsetsWithDup([4, 4, 4, 1, 4]))
