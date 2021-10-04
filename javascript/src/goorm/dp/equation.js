/**
 * @link https://level.goorm.io/exam/43098/%EB%93%B1%EC%8B%9D-%EB%A7%8C%EB%93%A4%EA%B8%B0/quiz/1
 */
const readline = require("readline");
const rl = readline.createInterface({
	input: process.stdin,
	output: process.stdout
});

let firstInput = false

rl.on("line", function(line) {
	if(firstInput) {
        console.log(solution(line.split(' ').map(v => +v)))
        rl.close()
        return
    }
    firstInput = true
	
}).on("close", function() {
	process.exit();
});

let total = 0

/**
 * @param {[number]} values [2 1 3]
 */
function solution(values) {
    const result = values.splice(values.length - 1)[0]

    calc(values.slice(1), values[0], result, '+')
    calc(values.slice(1), values[0], result, '-')

    return total
}

/**
 * @param {[number]} values 
 * @param {number} value 
 * @param {number} result 
 * @param {'+'|'-'} operation
 */
function calc(values, value, result, operation) {
    if(value < 0 && value > 20) {
        return
    }

    if(values.length !== 0) {
        for(let i = 0; i < values.length; i++) {
            let v = 0
            if (operation === '+') {
                v = value + values[i]
            } else {
                v = value - values[i]
            }

            const slice = values.slice(i + 1)
            if(slice.length === 0) {
                if(v === result) {
                    total++
                }
                return
            }
    
            calc(values.slice(i + 1), v, result, '+')
            calc(values.slice(i + 1), v, result, '-')
        }
    }
}
