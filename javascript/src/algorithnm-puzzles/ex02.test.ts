/**
 * nPr 전체 n 개에서 r 개를 뽑는다.
 * 순서 상관 있음
 *
 * ex) 6P2 인 경우 = 6 * 5
 * 5P3 = 5 * 4 * 3
 */
const assert = require('assert')

describe('순열', function() {
    it('순열 공식', function() {
        function nPr(n, r) {
            let result = 1;
            for(let i = n - r + 1; i <= n; i++) {
                result *= i;
            }
            return result;
        }
        assert.equal(nPr(6, 2), 30)
    })
})

/**
 * nCr = n! / r!(n - r)! = nPr / r!
 * = n-1Cr-1 + n-1Cr
 * = nCr-1 * (n - r + 1)/r, nC0 = 1
 */
describe('조합', function () {
    it('조합 공식', function () {

    });
})
