/**
 * 특정 구간의 합
 * 난이도 쉬움
 */
const readline = require("readline");
const rl = readline.createInterface({
	input: process.stdin,
	output: process.stdout
});

const cntInput = 3
const inputList = []

rl.on("line", function(line) {
	inputList.push(line)
    if(inputList.length === cntInput) {
        solution()
        rl.close()
    }
}).on("close", function() {
	process.exit();
});

function solution() {
    const values = inputList[1].split(' ').map(v => +v)
    const range = inputList[2].split(' ').map(v => +v)
    const res = values.slice(range[0] - 1, range[1])
        .reduce((pre, cur) => pre + cur)

    console.log(res)
}
