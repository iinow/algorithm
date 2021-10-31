function combine(n: number, k: number): number[][] {
  const res: number[][] = []
  const list = Array(n)
    .fill(0)
    .map((_, index) => index + 1)

  const recursive = (values: number[], copyList: number[]) => {
    if (values.length === k) {
      res.push([...values])
      return
    }

    for (let i = 0; i < copyList.length; i++) {
      values.push(copyList[i])
      recursive(
        values,
        copyList.filter((_, index) => index > i)
      )
      values.pop()
    }
  }

  recursive([], list)
  return res
}

/**
 * [
  [1,2],
  [1,3],
  [1,4],
  [2,3],
  [2,4],
  [3,4]
]
 */
console.log(combine(4, 2))
