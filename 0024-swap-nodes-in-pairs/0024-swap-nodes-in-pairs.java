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
    public ListNode swapPairs(ListNode head) {
        ListNode first = null;
        ListNode next = null;
        while (head != null) {
            if (head.next != null) {
                ListNode temp = new ListNode(head.next.val, new ListNode(head.val));
                if (first == null) {
                    first = temp;
                    next = first.next;
                } else {
                    next.next = temp;
                    next = next.next.next;
                }
                head = head.next.next;
            } else {
                if (first == null) {
                    first = new ListNode(head.val);
                    head = head.next;
                } else {
                    next.next = new ListNode(head.val);
                    head = head.next;
                }
            }
        }
        return first;
    }
}