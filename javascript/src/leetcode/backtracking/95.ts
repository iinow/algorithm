/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     val: number
 *     left: TreeNode | null
 *     right: TreeNode | null
 *     constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.left = (left===undefined ? null : left)
 *         this.right = (right===undefined ? null : right)
 *     }
 * }
 */
// eslint-disable-next-line @typescript-eslint/ban-ts-comment
//@ts-ignore
class TreeNode {
  val: number
  left: TreeNode | null
  right: TreeNode | null
  constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
    this.val = val === undefined ? 0 : val
    this.left = left === undefined ? null : left
    this.right = right === undefined ? null : right
  }
}

function generateTrees(n: number): Array<TreeNode | null> {
  const memo = new Map()

  function buildTree(arr: number[]) {
    if (!arr.length) return [null]
    if (memo.has(arr.join())) return memo.get(arr.join())
    const result: TreeNode[] = []

    for (let i = 0; i < arr.length; i++) {
      const left = buildTree(arr.slice(0, i))
      const right = buildTree(arr.slice(i + 1))

      for (const curLeft of left) {
        for (const curRight of right) {
          const tree = new TreeNode(arr[i])
          tree.left = curLeft
          tree.right = curRight
          result.push(tree)
        }
      }
    }
    memo.set(arr.join(), result)
    return result
  }
  return buildTree([...Array(n)].map((_, i) => i + 1))
}

;[
  [new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3)))],
  [new TreeNode(1), null, new TreeNode(3), new TreeNode(2)],
  [new TreeNode(2), new TreeNode(1), new TreeNode(3)],
  [new TreeNode(3), new TreeNode(1), null, null, new TreeNode(2)],
  [new TreeNode(3), new TreeNode(2), null, new TreeNode(1)],
]
console.log(generateTrees(3))
