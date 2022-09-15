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
    public boolean isSymmetric(TreeNode root) {
        return matchTreeNode(root.left, root.right);
    }
    
    private boolean matchTreeNode(TreeNode a, TreeNode b) {
        if (a == null && b != null) {
            return false;
        }
        if (b == null && a != null) {
            return false;
        }
        if (a == null && b == null) {
            return true;
        }
        if (a.left == null && a.right == null && b.left == null && b.right == null) {
            return a.val == b.val;
        }
        return a.val == b.val && matchTreeNode(a.left, b.right) && matchTreeNode(a.right, b.left);
    }
}