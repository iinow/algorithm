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
    /**
    * 1. 마지막 노드인가 아닌가 구분
      2. 오른쪽 노드는 스킵
      3. 왼쪽 노드면 누적 덧셈
    */
    public int sumOfLeftLeaves(TreeNode root) {
        int sum = sum(root.left, true);
        sum += sum(root.right, false);
        return sum;
    }
    
    private int sum(TreeNode node, boolean isLeft) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return isLeft ? node.val : 0;
        }
        int sum = 0;
        sum += sum(node.left, true);
        sum += sum(node.right, false);
        return sum;
    }
}