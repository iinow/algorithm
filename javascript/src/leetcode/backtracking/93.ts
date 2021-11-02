function restoreIpAddresses(s: string): string[] {
  return [
    ...new Set(
      Array.from(Array(80 + 1).keys())
        .map((v) => v.toString(3))
        .map((v) => {
          if (v.length === 4) {
            return v
          }
          return (
            Array.from(Array(4 - v.length).keys())
              .map((_) => '0')
              .join('') + v
          )
        })
        .map((v) =>
          v
            .split('')
            .map((n) => Number(n))
            .map((n) => n + 1)
        )
        .filter((v) => v.reduce((a, b) => a + b) === s.length)
        .map((v) => {
          let str = s
          return v
            .map((v2) => {
              const ss = str.substr(0, v2)
              str = str.substr(v2)
              return ss
            })
            .map((v2) => Number(v2))
            .filter((v2) => Number(v2) < 256)
        })
        .filter((v) => v.length === 4)
        .filter((v) => v.join('').length === s.length)
        .map((v) => v.join('.'))
    ),
  ]
}

console.log(restoreIpAddresses('010010'))
