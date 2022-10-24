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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode first = head;
        while(head != null) {
            if (head.next == null) {
                break;
            }
            int value = head.val;
            ListNode next = head.next;
            while(next != null) {
                if (next.val != value) {
                    break;
                }
                next = next.next;    
            }
            head.next = next;
            head = next;
        }
        
        return first;
    }
}