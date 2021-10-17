/**
 * @link https://leetcode.com/problems/two-sum/
 * @param nums
 * @param target
 * @returns
 */
function twoSum(nums: number[], target: number): number[] {
  for (let i = 0; i < nums.length - 1; i++) {
    for (let j = i + 1; j < nums.length; j++) {
      if (nums[i] + nums[j] === target) {
        return [i, j]
      }
    }
  }
  return []
}

const nums = [3, 3]
const target = 6

console.log(twoSum(nums, target))
