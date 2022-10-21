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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode first = null;
        ListNode next = null;
        final int length = lists.length;
        
        while (true) {
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int i = 0; i < length; i++) {
                if (lists[i] == null) {
                    continue;
                }
                if (lists[i].val < min) {
                    min = lists[i].val;
                    minIndex = i;
                }
            }
            if (minIndex == -1) {
                break;
            }
            
            lists[minIndex] = lists[minIndex].next;
            if (first == null) {
                first = new ListNode(min);
                next = first;
                continue;
            }
            next.next = new ListNode(min);
            next = next.next;
        }
        return first;
    }
}