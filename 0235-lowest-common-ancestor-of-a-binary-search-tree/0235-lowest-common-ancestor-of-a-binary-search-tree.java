/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return recursive(root, p, q);
    }
    
    private TreeNode recursive(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) {
            return null;
        }

        TreeNode left = recursive(node.left, p, q);
        TreeNode right = recursive(node.right, p, q);
        if (left != null && right != null) {
            return node;
        }

        if (node.val == p.val || node.val == q.val) {
            return node;
        }

        if (left != null) {
            return left;
        }

        if (right != null) {
            return right;
        }

        return null;
    }
}