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
    public void reorderList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode copy = head;
        while (copy != null) {
            list.add(copy.val);
            copy = copy.next;
        }

        ListNode first = new ListNode(list.get(0));
        ListNode next = first;
        int length = list.size();
        if (length == 1) {
            return;
        }

        for (int i = 1; i < length; i++) {
            if (i % 2 == 0) {
                next.next = new ListNode(list.get(i / 2));
                next = next.next;
            } else {
                next.next = new ListNode(list.get(length - 1 - (i / 2)));
                next = next.next;
            }
        }
        head.next = first.next;
    }
}