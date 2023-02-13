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
    
    private int min = Integer.MAX_VALUE;
    
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        recursive(root, 1);
        return min;
    }
    
    private void recursive(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            this.min = Math.min(depth, this.min);
        }
        if (min < depth) {
            return;
        }
        
        recursive(node.left, depth + 1);
        recursive(node.right, depth + 1);
    }
}