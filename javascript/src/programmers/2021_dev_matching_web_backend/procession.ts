function solution(rows: number, columns: number, queries: number[][]) {
  const array = Array.from(Array(rows).keys()).map((_, index) =>
    Array.from(Array(columns).keys()).map((v) => {
      return v + 1 + index * columns
    })
  )
  const answer: number[] = []

  queries
    .map((v) => v.map((v2) => v2 - 1))
    .forEach((v) => {
      const startX = v[0]
      const startY = v[1]
      const endX = v[2]
      const endY = v[3]
      const diffX = endX - startX
      const diffY = endY - startY
      const countInner = (diffX - 1) * (diffY - 1)
      const count = (diffX + 1) * (diffY + 1) - countInner

      const targets: number[] = []
      let temp = 0
      let currentX = startX,
        currentY = startY
      for (let i = 0; i < count + 1; i++) {
        if (currentX === startX && currentY < endY) {
          currentY += 1
        } else if (currentY === endY && currentX < endX) {
          currentX += 1
        } else if (currentX === endX && currentY > startY) {
          currentY -= 1
        } else if (currentY === startY && currentX > startX) {
          currentX -= 1
        }

        const value = temp
        temp = array[currentX][currentY]
        if (value === 0) {
          continue
        }

        targets.push(temp)
        array[currentX][currentY] = value
      }

      answer.push(Math.min(...targets))
    })

  console.log(array)
  return answer
}

console.log(solution(10, 3, []))
