/*
const shape = [
  ['*', '*', '*'],
  ['*', ' ', '*'],
  ['*', '*', '*'],
]

function solution(n = 3, shape: string[][] = []) {
  const line = n / 3
  const res: string[][] = []

  for (let i = 0; i < n; i++) {
    if (res.length !== i + 1) {
      res.push([])
    }
    for (let j = 0; j < n; j++) {
      res[i].push('*')
    }
  }

  console.log(res)
}

solution()
*/
