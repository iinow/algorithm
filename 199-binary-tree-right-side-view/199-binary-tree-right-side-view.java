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
    //key = level, value = value
    private Map<Integer, Integer> map = new LinkedHashMap<>();
    
    public List<Integer> rightSideView(TreeNode root) {
        recursive(root, 0);
        return map.values().stream().collect(Collectors.toList());
    }
    
    private void recursive(TreeNode node, int level) {
        if (node == null) return;
        if (!map.containsKey(level)) {
            map.put(level, node.val);
        }
        recursive(node.right, level + 1);
        recursive(node.left, level + 1);
    }
}