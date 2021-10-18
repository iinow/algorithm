/**
 * 11. Container With Most Water
 * @param height
 */
function maxArea(height: number[]): number {
  let res = 0
  let start = 0
  let end = height.length - 1
  while (start < end) {
    // increase smaller one
    const minValue = Math.min(height[start], height[end])
    const area = minValue * Math.abs(start - end)
    res = Math.max(res, area)
    if (height[start] < height[end]) {
      start++
    } else {
      end--
    }
  }
  return res
}

const height = [1, 8, 6, 2, 5, 4, 8, 3, 7]
console.log(maxArea(height))
