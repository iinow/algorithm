const removeInvalidParentheses = (s: string) => {
  const res: string[] = [],
    visit = new Set([s]),
    q: string[] = [s]
  let found = false

  while (q.length) {
    const cur = q.shift()
    if (!cur) {
      continue
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