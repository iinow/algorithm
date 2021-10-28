function combinationSum(candidates: number[], target: number): number[][] {
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

    for (let i = 0; i < cans.length; i++) {
      values.push(cans[i])
      recursive(sum + cans[i], cans, values)
      values.pop()
    }
  }

  recursive(0, candidates, [])

  return res
}

console.log(combinationSum([2, 3, 6, 7], 7))
