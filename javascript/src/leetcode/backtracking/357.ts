function countNumbersWithUniqueDigits(n: number): number {
  if (n === 0) {
    return 1
  }

  if (n === 1) {
    return 10
  }

  let res = 9
  for (let i = 0; i < n - 1; i++) {
    res *= 9 - i
  }

  return res + countNumbersWithUniqueDigits(n - 1)
}

console.log(countNumbersWithUniqueDigits(2))
