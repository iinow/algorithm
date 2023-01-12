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
    public int sumNumbers(TreeNode root) {
        return recursive(root, 0);
    }
    
    private int recursive(TreeNode node, int sum) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 10 * sum + node.val;
        }
        int total = 0;
        total += recursive(node.left, 10 * sum + node.val);
        total += recursive(node.right, 10 * sum + node.val);
        
        return total;
    }
}