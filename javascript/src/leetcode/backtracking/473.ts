function makesquare(matchsticks: number[]): boolean {
  matchsticks.sort((a, b) => b - a)
  if (matchsticks.length < 4) {
    return false
  }

  const sum = matchsticks.reduce((a, b) => a + b)
  if (sum % 4 !== 0) {
    return false
  }

  const side = sum / 4

  const recursive = (
    lines: number[] = matchsticks,
    acc: number[] = []
  ): boolean => {
    if (acc.length === 4) {
      if (new Set(acc).size === 1) {
        return true
      }
    }

    for (let i = 0; i < lines.length - 1; i++) {
      const value = acc[acc.length - 1]
      const sum = value + lines[i]
      if (sum > side) {
        continue
      }

      if (
        recursive(
          lines.filter((_, index) => index !== i),
          acc
        )
      )
        return true
    }
    return false
  }

  return recursive()
}

console.log(makesquare([5, 5, 5, 5, 4, 4, 4, 4, 3, 3, 3, 3]))
