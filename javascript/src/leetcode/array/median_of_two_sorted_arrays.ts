/**
 * @link https://leetcode.com/problems/median-of-two-sorted-arrays/
 * @param nums1
 * @param nums2
 */
function findMedianSortedArrays(nums1: number[], nums2: number[]): number {
  const array = [...nums1, ...nums2].sort((a, b) => {
    if (a > b) {
      return 1
    } else if (a < b) {
      return -1
    }
    return 0
  })

  if (array.length % 2 === 0) {
    return (array[array.length / 2 - 1] + array[array.length / 2]) / 2
  }
  return array[Number((array.length / 2).toFixed()) - 1]
}

const nums1 = [2]
const nums2 = []

console.log(findMedianSortedArrays(nums1, nums2))
