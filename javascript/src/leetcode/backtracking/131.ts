const partition = function (s) {
  const temp: string[] = []
  const index = 0
  const result: string[][] = []

  function backtracking(temp: string[], index: number) {
    if (index === s.length) result.push([...temp])

    for (let i = index; i < s.length; i++) {
      if (isPalindrome(index, i)) {
        temp.push(s.slice(index, i + 1))
        backtracking(temp, i + 1)
        temp.pop()
      }
    }
  }
  backtracking(temp, index)

  function isPalindrome(left: number, right: number) {
    while (left < right) {
      if (s[left++] !== s[right--]) return false
    }
    return true
  }
  return result
}

console.log(partition('aab'))
