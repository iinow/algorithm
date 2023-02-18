/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func invertTree(root *TreeNode) *TreeNode {
    return swap(root)
}

func swap(node *TreeNode) *TreeNode {
    if node == nil {
        return node
    }
    temp := node.Left
    node.Left = node.Right;
    node.Right = temp;
    
    swap(node.Left)
    swap(node.Right)
    return node
}