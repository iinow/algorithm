function solution(words = [], queries = []) {
    const temp = {}
    return queries
        .map(query => new RegExp(`^${query.replace(/\?/g, '.')}$`))
        .map(regex => {
            if(!temp[regex.source]) {
                temp[regex.source] = words.filter(word => regex.test(word)).length
            }
            return temp[regex.source]
        })
}

const inputWords = ["frodo", "front", "frost", "frozen", "frame", "kakao"]
const queries = ["fro??", "????o", "fr???", "fro???", "pro?"]

console.log(solution(inputWords, queries))