/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    private ListNode res = null;
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        recursive(head);
        head.next = null;
        return res;
    }
    
    private ListNode recursive(ListNode node) {
        if (node.next == null) {
            res = node;
            return node;
        }
        ListNode root = recursive(node.next);
        root.next = node;
        root = root.next;
        return root;
    }
}