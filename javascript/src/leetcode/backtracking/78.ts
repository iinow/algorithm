function subsets(nums: number[]): number[][] {
  const res: number[][] = []
  const recursive = (values: number[] = [], copyNums: number[] = nums) => {
    res.push([...values])
    if (values.length === nums.length) {
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

console.log(subsets([1, 2, 3]))
