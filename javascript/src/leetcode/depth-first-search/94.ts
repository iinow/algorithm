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

function inorderTraversal(root: TreeNode | null): number[] {
  if (!root) {
    return []
  }

  const res = inorderTraversal(root.left)
  res.push(root.val)
  console.log(root.val)
  res.push(...inorderTraversal(root.right))
  return res
}

const n1 = new TreeNode(1, null, new TreeNode(2, new TreeNode(3)))
console.log(inorderTraversal(n1))
