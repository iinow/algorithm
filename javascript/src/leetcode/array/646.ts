/**
 * @link https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/646/
 * @param nums
 * @param k
 * @returns
 */
function rotate(nums: number[], k: number): void {
  const count = k % nums.length
  if (nums.length === 0) {
    return
  }

  if (count === 0) {
    return
  }

  const first = [...nums.slice(-count)]
  const last = [...nums.slice(0, nums.length - count)]
  const temp = [...first, ...last]

  temp.forEach((v, index) => (nums[index] = v))
}

const array = [1, 2, 3, 4]
const k = 4

rotate(array, k)
