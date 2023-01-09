/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func preorderTraversal(root *TreeNode) []int {
    arr := make([]int, 0)

	arr = recursive(&arr, root)
    return arr
}

func recursive(cArray *[]int, node *TreeNode) []int {
	if node == nil {
		return make([]int, 0)
	}

	n := append((*cArray), node.Val)

	if node.Left != nil {
		n = recursive(&n, node.Left)
	}

	if node.Right != nil {
		n = recursive(&n, node.Right)
	}
	return n
}