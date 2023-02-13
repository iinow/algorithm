/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return recursive(root, 1);
    }
    
    private int recursive(TreeNode node, int depth) {
        if (node == null) {
            return depth;
        }
        
        if (node.left == null && node.right == null) {
            return depth;
        }
        
        return Math.max(recursive(node.left, depth + 1), recursive(node.right, depth + 1));
    }
}