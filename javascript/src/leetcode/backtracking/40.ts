function combinationSum2(candidates: number[], target: number): number[][] {
  candidates.sort((a, b) => {
    if (a > b) {
      return 1
    } else if (a < b) {
      return -1
    }
    return 0
  })
  const res: number[][] = []
  const temp = new Set<string>()

  const recursive = (sum: number, cans: number[], values: number[]) => {
    if (sum === target) {
      const item = [...values].sort()
      if (temp.has(item.join(''))) {
        return false
      }

      temp.add(item.join(''))
      res.push(item)
      return true
    }

    if (sum > target) {
      return false
    }

    const numTemp = new Set<number>()
    for (let i = 0; i < cans.length; i++) {
      if (numTemp.has(cans[i])) {
        continue
      }
      values.push(cans[i])
      recursive(
        sum + cans[i],
        cans.filter((v, ci) => ci !== i),
        values
      )
      values.pop()
      numTemp.add(cans[i])
    }
  }

  recursive(0, candidates, [])

  return res
}

console.log(
  combinationSum2(
    [
      1,
      1,
      1,
      1,
      1,
      1,
      1,
      1,
      1,
      1,
      1,
      1,
      1,
      1,
      1,
      1,
      1,
      1,
      1,
      1,
      1,
      1,
      1,
      1,
      1,
      1,
    ],
    27
  )
)
