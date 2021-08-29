const visit = new Array(200)

/**
 * @param {number} n 1 <= n <= 200
 * @param {number[][]} computers 
 * @returns network count
 */
function solution(n, computers) {
    let answer = 0;

    for(let i = 0; i < n; i++) {
        if(!visit[i]) {
            answer++
        }
        dfs(i, computers)
    }
    return answer;
}

/**
 * @param {number} start 
 * @param {number[][]} tmp 
 */
function dfs(start, tmp) {
    if(visit[start]) {
        return
    }
    visit[start] = true

    for(let i = 0; i < tmp[start].length; i++) {
        console.log(start, i, !!tmp[start][i])
        if(tmp[start][i]) {
            dfs(i, tmp)
        }
    }
}

let res = solution(3, [[ 1, 1, 0], [1, 1, 0], [0, 0, 1]])
console.log(res)