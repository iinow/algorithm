function solution(info: string[], query: string[]): number[] {
  const querys = query.map((q) => q.split(' ').filter((v) => v !== 'and'))
  const infos: { [key: string]: number[] } = info
    .map((i) => i.split(' '))
    .reduce((pre, cur) => {
      const str = cur.filter((_, index) => index !== cur.length - 1).join(' ')
      pre[str] = pre[str] || []
      pre[str].push(Number(cur[4]))
      return pre
    }, Object.create(null))
  return querys
    .map(
      (q) =>
        Object.keys(infos)
          .filter((key) => {
            const i = key.split(' ')
            if (q[0] !== '-') {
              if (q[0] !== i[0]) return false
            }
            if (q[1] !== '-') {
              if (q[1] !== i[1]) return false
            }
            if (q[2] !== '-') {
              if (q[2] !== i[2]) return false
            }
            if (q[3] !== '-') {
              if (q[3] !== i[3]) return false
            }
            return true
          })
          .map((key) => infos[key])
          .flatMap((values) => values)
          .filter((v) => v >= Number(q[4])).length
    )
    .flatMap((v) => v)
}

console.log(
  solution(
    [
      'java backend junior pizza 150',
      'python frontend senior chicken 210',
      'python frontend senior chicken 150',
      'cpp backend senior pizza 260',
      'java backend junior chicken 80',
      'python backend senior chicken 50',
    ],
    [
      'java and backend and junior and pizza 100',
      'python and frontend and senior and chicken 200',
      'cpp and - and senior and pizza 250',
      '- and backend and senior and - 150',
      '- and - and - and chicken 100',
      '- and - and - and - 150',
    ]
  )
)
