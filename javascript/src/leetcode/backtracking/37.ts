/**
 * 참조
 * @param board
 */
const solveSudoku = function (board: string[][]) {
  function sudokuSolver(board: string[][]) {
    for (let i = 0; i < 9; i++) {
      for (let j = 0; j < 9; j++) {
        if (board[i][j] === '.') {
          let char = '1'
          while (Number(char) <= 9) {
            if (isValidSudoku(i, j, char)) {
              board[i][j] = char

              if (sudokuSolver(board)) return true
              else board[i][j] = '.'
            }
            char = (parseInt(char) + 1).toString()
          }
          return false
        }
      }
    }
    return true
  }

  function isValidSudoku(row: number, col: number, char: string) {
    for (let i = 0; i < 9; i++) {
      if (board[row][i] === char) return false
    }

    for (let i = 0; i < 9; i++) {
      if (board[i][col] === char) return false
    }

    const x = Math.floor(row / 3) * 3
    const y = Math.floor(col / 3) * 3

    for (let i = 0; i < 3; i++) {
      for (let j = 0; j < 3; j++) {
        if (board[x + i][y + j] === char) return false
      }
    }
    return true
  }
  sudokuSolver(board)
}

const input = [
  ['5', '3', '.', '.', '7', '.', '.', '.', '.'],
  ['6', '.', '.', '1', '9', '5', '.', '.', '.'],
  ['.', '9', '8', '.', '.', '.', '.', '6', '.'],
  ['8', '.', '.', '.', '6', '.', '.', '.', '3'],
  ['4', '.', '.', '8', '.', '3', '.', '.', '1'],
  ['7', '.', '.', '.', '2', '.', '.', '.', '6'],
  ['.', '6', '.', '.', '.', '.', '2', '8', '.'],
  ['.', '.', '.', '4', '1', '9', '.', '.', '5'],
  ['.', '.', '.', '.', '8', '.', '.', '7', '9'],
]
solveSudoku(input)

console.log(input)
