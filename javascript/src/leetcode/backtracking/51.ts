function solveNQueens(n: number): string[][] {
  const res: number[][] = []

  const valid = (
    values: number[] = [],
    columnIndex: number,
    rowIndex: number
  ): boolean => {
    if (values.includes(columnIndex)) {
      return false
    }

    if (values.map((v, i) => i - v).includes(rowIndex - columnIndex)) {
      return false
    }

    if (values.map((v, i) => i + v).includes(rowIndex + columnIndex)) {
      return false
    }

    return true
  }

  const recursive = (
    rowIndex = 0,
    values: number[] = [],
    columnValues: number[] = Array(n)
      .fill(0)
      .map((_, index) => index)
  ): boolean => {
    if (rowIndex === n) {
      res.push([...values])
      return false
    }
    for (let i = 0; i < columnValues.length; i++) {
      if (valid(values, columnValues[i], rowIndex)) {
        values.push(columnValues[i])
        recursive(
          rowIndex + 1,
          values,
          columnValues.filter((v) => v !== columnValues[i])
        )
        values.pop()
      }
    }
    return true
  }

  recursive()
  return res.map((list) =>
    list.map((v) =>
      Array(list.length)
        .fill('.')
        .map((_, i) => {
          if (v === i) {
            return 'Q'
          }
          return _
        })
        .join('')
    )
  )
}

/**
 * n = 4 ->  [1,3,0,2]
 * [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 */
console.log(solveNQueens(4))
