/**
 * @param {number[]} nums
 * @return {number}
 */
var arrayPairSum = function(nums) {
    const sortedNums = nums.sort((a, b) => a - b);
    const length = sortedNums.length / 2;
    let sum = 0;

    for (let i = 0; i < length; i++) {
        sum += sortedNums[i * 2];
    }
    return sum;
};