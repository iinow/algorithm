function solution(
  enroll: string[],
  referral: string[],
  seller: string[],
  amount: number[]
) {
  const answer: { [key: string]: number } = {}
  const sellers: { [key: string]: number } = {}
  const temp: { [key: string]: string[] } = {}

  seller.forEach((v, index) => {
    sellers[v] = amount[index] * 100
  })
  enroll.forEach((v) => (answer[v] = 0))
  referral.forEach((v, index) => {
    if (v === '-') {
      return
    }
    if (!temp[v]) {
      temp[v] = []
    }
    temp[v].push(enroll[index])
  })

  const recursive = (sellerName: string, parentName: string) => {}
  Object.keys(sellers).map((name) => {
    const profit = sellers[name]
    const parentProfit = Math.floor(profit * 0.1)
    const mineProfit = parentProfit === 0 ? profit : profit - parentProfit

    //반복
    //자신이 받는 금액은 10퍼센트 차감된 금액에서

    answer[name] = answer[name] + mineProfit
    console.log(parentProfit)
    // console.log(name, profit, mineProfit)
  })
  console.log(temp)
  console.log(sellers)
  return answer
}

;[360, 958, 108, 0, 450, 18, 180, 1080]
console.log(
  solution(
    ['john', 'mary', 'edward', 'sam', 'emily', 'jaimie', 'tod', 'young'],
    ['-', '-', 'mary', 'edward', 'mary', 'mary', 'jaimie', 'edward'],
    ['young', 'john', 'tod', 'emily', 'mary'],
    [12, 4, 2, 5, 10]
  )
)
