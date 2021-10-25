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

function isValidBST(
  root: TreeNode | null,
  min = -Infinity,
  max = Infinity
): boolean {
  if (!root) {
    return true
  }

  if (!root) return true
  if (min >= root.val || root.val >= max) {
    console.log(root, min, max)
    return false
  }
  return (
    isValidBST(root.left, min, root.val) &&
    isValidBST(root.right, root.val, max)
  )
}

const res = new TreeNode(
  5,
  new TreeNode(4, null, null),
  new TreeNode(6, new TreeNode(3), new TreeNode(7))
)
console.log(isValidBST(res))
