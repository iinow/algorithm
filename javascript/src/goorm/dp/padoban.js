/**
 * @link https://level.goorm.io/exam/43272/%ED%8C%8C%EB%8F%84%EB%B0%98-%EC%88%98%EC%97%B4/quiz/1
 * 파도반 수열 DP 문제
 */

const readline = require("readline");
const rl = readline.createInterface({
	input: process.stdin,
	output: process.stdout
});

rl.on("line", function(line) {
	console.log(solution(+line))
	rl.close();
}).on("close", function() {
	process.exit();
});

const arr = [1, 1, 1, 2, 2]

function solution(num) {
    if(num <= arr.length) {
        return arr[num - 1]
    }

    while(true) {
        if(arr.length === num) {
            return arr[num - 1]
        }

        const secondIndex = arr[arr.length - 1]
        const firstIndex = arr[arr.length - 5]
        arr.push(secondIndex + firstIndex)
    }
}