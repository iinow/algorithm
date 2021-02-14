/**
 * 메모화와 동적 계획법
 *
 * 패밀리 레스토랑에 가서, 여러 개의 테이블에 사람을 나누어 낮게 하려고 합니다. 이때,
 * 한 사람만 앉는 테이블이 없게 그룹을 지어야 합니다.
 * 인원수를 나누는 패턴만 구하면 되며, 누가 어디에 앉는지 등은 고려하지 않아도 괜찮습니다.
 * 예를 들어 6명이라면, 다음과 같이 4가지가 됩니다.
 *
 * 2명 + 2명 + 2명
 * 2명 + 4명
 * 3명 + 3명
 * 6명
 *
 * 문) 한 개의 테이블에 앉을 수 있는 사람은 최대 10명입니다. 100명이 하나 이상의 테이블에 나누어 앉는 패턴을 구하세요.
 */
describe('Test suite', function() {
  it('should be ok', function() {
    let tablePeopleMaxCnt = 10
    let peopleCount = 100

    let memo = {}

    /**
     * @param remain 남은 인원
     * @param pre
     * @returns {number}
     */
    function check(remain, pre) {
      if (memo[[remain, pre]]) {
        return memo[[remain, pre]]
      }
      if (remain < 0) {
        return 0
      } else if (remain === 0) {
        return 1
      }

      let cnt = 0
      for (let i = pre; i <= tablePeopleMaxCnt; i++) {
        cnt += check(remain - i, i)
      }
      return (memo[[remain, pre]] = cnt)
    }

    assert.equal(check(peopleCount, 2), 437420)
  })
})
