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

function pathSum(root: TreeNode | null, targetSum: number): number[][] {
  const res: number[][] = []
  if (!root) {
    return res
  }

  const recursive = (
    child: TreeNode = root,
    currentSum = 0,
    values: number[] = []
  ) => {
    if (!child) {
      return
    }

    currentSum += child.val
    values.push(child.val)

    if (child.left === null && child.right === null) {
      if (currentSum === targetSum) {
        res.push([...values])
      }
      return
    }

    if (child.left) {
      recursive(child.left, currentSum, [...values])
    }

    if (child.right) {
      recursive(child.right, currentSum, [...values])
    }
  }

  recursive()
  return res
}

const root: TreeNode = new TreeNode(
  5,
  new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2))),
  new TreeNode(
    8,
    new TreeNode(13),
    new TreeNode(4, new TreeNode(5), new TreeNode(1))
  )
)
const targetSum = 22

console.log(pathSum(root, targetSum))
