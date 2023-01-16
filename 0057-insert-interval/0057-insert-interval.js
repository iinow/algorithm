/**
 * @param {number[][]} intervals
 * @param {number[]} newInterval
 * @return {number[][]}
 */
var insert = function(intervals, newInterval) {
    let newArr = [...intervals]
    newArr.push(newInterval)
    newArr.sort((a,b)=>a[0]-b[0])
    
    let res = []
    for(let [x,y] of newArr){
        if(!res.length || res[res.length-1][1] < x){
            res.push([x,y])
        }else{
            res[res.length-1][1] = Math.max(res[res.length-1][1],y)
        }
    }
    return res;
};