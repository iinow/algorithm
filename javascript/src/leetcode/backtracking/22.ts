/**
 * 참조
 * @param n
 * @param current
 * @param open
 * @param close
 * @param res
 * @returns
 */
function generateParenthesis(
  n: number,
  current = '(',
  open = 1,
  close = 0,
  res: string[] = []
): string[] {
  if (close === n) {
    res.push(current)
    return res
  }

  open > close && generateParenthesis(n, current + ')', open, close + 1, res)
  open < n && generateParenthesis(n, current + '(', open + 1, close, res)
  return res
}

console.log(generateParenthesis(3))
