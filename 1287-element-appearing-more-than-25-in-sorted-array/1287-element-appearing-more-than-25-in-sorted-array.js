/**
 * @param {number[]} arr
 * @return {number}
 */
var findSpecialInteger = function(arr) {
    const min = Math.ceil(arr.length * 0.25)
    let maxKey = 0, maxValue = 0
    const map = {}
    for (let a of arr) {
        if (!map[a]) {
            map[a] = 0
        }
        
        map[a]++
    }
    
    for (let key in map) {
        if (maxValue < map[key]) {
            maxKey = key;
            maxValue = map[key]
        }
    }
    return maxKey;
};