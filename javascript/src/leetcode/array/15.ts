/**
 * two point
 * @param nums
 * @returns
 */
function threeSum(nums: number[]): number[][] {
  if (nums.length < 3) {
    return []
  }
  const result: number[][] = []
  const arr = nums.sort((a, b) => a - b)
  for (let i = 0; i < arr.length; i++) {
    if (i > 0 && arr[i] === arr[i - 1]) continue
    const target = 0 - arr[i]
    let left = i + 1
    let right = nums.length - 1

    while (left < right) {
      if (arr[left] + arr[right] === target) {
        result.push([arr[i], arr[left], arr[right]])
        while (arr[left] === arr[left + 1]) {
          left++
        }
        while (arr[right] === arr[right - 1]) {
          right--
        }
        left++
        right--
      } else if (arr[left] + arr[right] > target) {
        right--
      } else {
        left++
      }
    }
  }
  return result
}

console.log(threeSum([-1, 0, 1, 2, -1, -4]))
