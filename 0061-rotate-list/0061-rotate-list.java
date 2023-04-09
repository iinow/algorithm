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
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0) return head;
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        
        ListNode first = null, next = null;
        if (list.isEmpty()) {
            return head;
        }
        int rotate = k % list.size();
        for (int i = list.size() - rotate; i < list.size(); i++) {
            if (first == null) {
                first = new ListNode(list.get(i));
                next = first;
                continue;
            }
            next.next = new ListNode(list.get(i));
            next = next.next;
        }
        
        for (int i = 0; i < list.size() - rotate; i++) {
            if (first == null) {
                first = new ListNode(list.get(i));
                next = first;
                continue;
            }
            next.next = new ListNode(list.get(i));
            next = next.next;
        }
        
        return first;
    }
}