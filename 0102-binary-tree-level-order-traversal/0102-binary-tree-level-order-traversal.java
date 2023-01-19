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
    
    private Map<Integer, List<Integer>> map = new TreeMap<>();
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        recursive(0, root);
        return map.values().stream().collect(Collectors.toList());
    }
    
    private void recursive(final int level, TreeNode node) {
        if (node == null) {
            return;
        }
        
        if (!map.containsKey(level)) {
            map.put(level, new ArrayList<>());
        }
        map.get(level).add(node.val);
        
        recursive(level + 1, node.left);
        recursive(level + 1, node.right);
    }
}