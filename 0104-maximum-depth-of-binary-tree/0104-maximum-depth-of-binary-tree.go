/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func maxDepth(root *TreeNode) int {
    return recursive(root, 0)
}

func recursive(node *TreeNode, depth int) int {
    if node == nil {
        return depth   
    }
    return int(math.Max(float64(recursive(node.Left, depth+1)), float64(recursive(node.Right, depth+1))))
}