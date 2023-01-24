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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        recursive(root, list, "");
        return list;
    }
    
    private void recursive(TreeNode node, List<String> list, String str) {
        if (node == null) {
            return;
        }
        
        if (str.length() == 0) {
            str = String.valueOf(node.val);
        } else {
            str = str + "->" + node.val;
        }
        
        if (node.left == null && node.right == null) {
            list.add(str);
            return;
        }
        
        recursive(node.left, list, str);
        recursive(node.right, list, str);
    }
}