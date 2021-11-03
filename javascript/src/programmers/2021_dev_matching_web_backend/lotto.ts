/**
 * 1 -> 6개 일치
 * 2 -> 5개 일치
 * 3 -> 4개 일치
 * 4 -> 3개 일치
 * 5 -> 2개 일치
 * 6 -> 낙첨
 * @param lottos 입력 번호
 * @param win_nums 당첨 번호
 * @returns [최소 순위, 최대 순위]
 */
function solution(lottos: number[], win_nums: number[]) {
  const inputLottos = lottos.filter((v) => v !== 0)
  const countUnknownNumber = lottos.length - inputLottos.length
  const matches = inputLottos.filter((v) => win_nums.includes(v))
  const countMatches = matches.length
  if (countUnknownNumber === 0 && countMatches === 0) {
    return [6, 6]
  }

  const max =
    countMatches === 0
      ? 1
      : win_nums.length + 1 - (countMatches + countUnknownNumber)
  const min = countMatches === 0 ? 6 : win_nums.length + 1 - countMatches

  return [max, min]
}

//3, 5
console.log(solution([1, 2, 3, 4, 5, 6], [7, 8, 9, 10, 11, 12]))
