function isAdditiveNumber(num: string): boolean {
  let result = false
  const recursive = (a: number, b: number, str: string = num, first = true) => {
    if (!first) {
      const sum = a + b
      if (!str.startsWith(String(sum))) {
        return
      }
      if (sum === Number(str)) {
        result = true
        return
      }
      str = b + str
    }

    for (let i = 1; i < str.length - 1; i++) {
      const start = str.slice(0, i)
      for (let j = i + 1; j < str.length; j++) {
        const end = str.slice(i, j)
        if (start.length !== String(Number(start)).length) {
          continue
        }

        if (end.length !== String(Number(end)).length) {
          continue
        }
        recursive(Number(start), Number(end), str.slice(j), false)

        if (result) {
          return true
        }
      }
    }
  }

  recursive(0, 0)
  return result
}
console.log(isAdditiveNumber('101'))
