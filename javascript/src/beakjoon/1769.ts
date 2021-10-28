function solution(value: number, count = 0) {
  while (true) {
    if (value.toString().length === 1) {
      console.log(count)
      if ([3, 6, 9].includes(value)) {
        console.log('YES')
      } else {
        console.log('NO')
      }
      return
    }

    value = value
      .toString()
      .split('')
      .map((v) => Number(v))
      .reduce((a, b) => a + b)

    count += 1
  }
}

solution(99999991444433223)
