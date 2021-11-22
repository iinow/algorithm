function solution(orders: string[], course: number[]) {
  const temp = new Map<string, number>()
  const recursive = (
    copyOrders: string[] = orders.filter((_, i) => i > 0),
    str = orders[0]
  ) => {
    if (copyOrders.length < 2) {
      return
    }

    for (let i = 0; i < copyOrders.length; i++) {
      const b = copyOrders[i].split('')
      const bb = str
        .split('')
        .filter((v) => b.includes(v))
        .sort((a, b) => {
          if (a > b) {
            return 1
          } else if (a < b) {
            return -1
          }
          return 0
        })
        .join('')
      console.log(str, copyOrders[i], bb)
      if (bb.length > 1) {
        if (!temp.has(bb)) {
          temp.set(bb, 1)
        }
        temp.set(bb, <number>temp.get(bb) + 1)
      }
    }

    recursive(
      copyOrders.filter((_, index) => index > 0),
      copyOrders[0]
    )
  }

  recursive()
  console.log(temp)
  const keys = [...temp.keys()].filter((v) => !!v)
  console.log(keys)
  return course
    .map((count) => keys.filter((key) => key.length === count))
    .flatMap((v) => v)
    .sort((a, b) => {
      if (a > b) {
        return 1
      } else if (a < b) {
        return -1
      }
      return 0
    })
}

console.log(
  solution(['ABCDE', 'AB', 'CD', 'ADE', 'XYZ', 'XYZ', 'ACD'], [2, 3, 5])
)
