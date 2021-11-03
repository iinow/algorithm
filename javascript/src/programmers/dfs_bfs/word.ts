function solution(begi: string, target: string, words: string[]): number {
  if (!words.includes(target)) {
    return 0
  }

  let max = Number.MAX_VALUE

  const recursive = (
    str: string = begi,
    copyWords: string[] = words,
    count = 0
  ) => {
    if (str === target) {
      max = count
      return
    }

    for (let i = 0; i < copyWords.length; i++) {
      const str1 = copyWords[i]
      const arrStr1 = str1.split('').map((v) => v.charCodeAt(0))
      const matches = str
        .split('')
        .map((v) => v.charCodeAt(0))
        .filter((v, index) => arrStr1[index] === v).length

      if (matches === begi.length - 1) {
        recursive(
          str1,
          copyWords.filter((_, index) => index > i),
          count + 1
        )
      }
    }
  }

  recursive()
  return max
}

console.log(solution('aaa', 'aab', ['aab']))
