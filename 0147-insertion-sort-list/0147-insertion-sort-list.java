import java.util.*;
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
    public ListNode insertionSortList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while(head != null) {
            list.add(head.val);
            head = head.next;
        }
        
        list = list.stream().sorted().collect(Collectors.toList());
        ListNode first = null;
        ListNode next = null;
        
        for (int v: list) {
            if (first == null) {
                first = new ListNode(v);
                next = first;
            } else {
                next.next = new ListNode(v);
                next = next.next;
            }
        }
        return first;
    }
}