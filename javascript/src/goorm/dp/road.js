/**
 * 특정 구간의 합
 * 난이도 쉬움
 */
 const readline = require("readline");
 const rl = readline.createInterface({
     input: process.stdin,
     output: process.stdout
 });
 
 let n = 0
 const inputList = []
 
 rl.on("line", function(line) {
     if(n !== 0) {
         inputList.push(line)

         if(inputList.length === n) {
            solution()
            rl.close()
        }
         return
     }

     n = +line
 }).on("close", function() {
     process.exit();
 });
 
 function solution() {
    const arr = inputList.map(input => input.split(' ').map(v => +v))
 }
 