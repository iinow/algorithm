/**
 * 참조
 * @param s
 * @returns
 */
const removeInvalidParentheses = (s: string) => {
  const res: string[] = [],
    visit = new Set([s]),
    q: string[] = [s]
  let found = false

  while (q.length) {
    const cur = q.shift()
    if (!cur) {
      break
    }
    if (isValid(cur)) {
      res.push(cur)
      found = true
    }
    if (found) continue
    for (let i = 0; i < cur.length; i++) {
      // bfs
      if (cur[i] != '(' && cur[i] != ')') continue
      const ss = cur.slice(0, i) + cur.slice(i + 1) // each string, removed one char all conditions
      console.log(ss)
      if (!visit.has(ss)) {
        q.push(ss)
        visit.add(ss)
      }
    }
  }
  if (res.length === 0) {
    return ['']
  }
  return res
}

const isValid = (s: string) => {
  let cnt = 0
  for (const c of s) {
    if (c == '(') {
      cnt++
    } else if (c == ')') {
      if (--cnt < 0) return false
    }
  }
  return cnt == 0
}

function invalidParentheses(s: string): boolean {
  let count = 0
  for (const char of s) {
    if (char === '(') {
      ++count
    }

    if (char === ')') {
      if (--count < 0) {
        return false
      }
    }
  }

  return count === 0
}

console.log(invalidParentheses('()))'))
console.log(removeInvalidParentheses('()())()'))
