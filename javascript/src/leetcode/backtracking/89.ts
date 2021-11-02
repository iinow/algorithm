function grayCode(n: number): number[] {
  return Array.from(
    Array(parseInt(new Array(n).fill(1).join(''), 2) + 1).keys()
  ).map((v) => v ^ (v >> 1))
}

console.log(grayCode(16))
