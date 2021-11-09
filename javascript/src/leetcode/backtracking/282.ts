function addOperators(num: string, target: number): string[] {
  const res: string[] = []
  const calculate = (values: string[]): number => {
    if (values.length === 1) {
      return Number(values[0])
    }

    if (values.indexOf('*') > 0) {
      const index = values.indexOf('*')
      const a = Number(values[index - 1])
      const b = Number(values[index + 1])
      return calculate([
        ...values.filter((_, i) => index - 1 > i),
        String(a * b),
        ...values.filter((_, i) => index + 1 < i),
      ])
    }

    if (values.indexOf('-') > 0) {
      const index = values.indexOf('-')
      const a = Number(values[index - 1])
      const b = Number(values[index + 1])
      return calculate([
        ...values.filter((_, i) => index - 1 > i),
        String(a - b),
        ...values.filter((_, i) => index + 1 < i),
      ])
    }

    if (values.indexOf('+') > 0) {
      const index = values.indexOf('+')
      const a = Number(values[index - 1])
      const b = Number(values[index + 1])
      return calculate([
        ...values.filter((_, i) => index - 1 > i),
        String(a + b),
        ...values.filter((_, i) => index + 1 < i),
      ])
    }

    return 0
  }
  const recursive = (
    copyNum: string[] = num.split(''),
    values: string[] = []
  ) => {
    if (copyNum.length === 0) {
      if (calculate(values) === target) {
        res.push(values.join(''))
      }
      return
    }

    for (let j = 0; j < copyNum.length; j++) {
      const value = copyNum.slice(0, j + 1)
      if (String(Number(value.join(''))).length !== value.join('').length) {
        continue
      }

      values.push(value.join(''))
      const arr = copyNum.slice(j + 1, copyNum.length)

      if (arr.length !== 0) {
        values.push('*')
        recursive(arr, values)
        values.pop()

        values.push('+')
        recursive(arr, values)
        values.pop()

        values.push('-')
        recursive(arr, values)
        values.pop()
      } else {
        recursive(arr, values)
      }

      values.pop()
    }
  }

  recursive()
  return res
}

console.log(addOperators('232', 8))
