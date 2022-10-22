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
import java.util.*;

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode first = null;
        ListNode next = null;
        Stack<Integer> stack = new Stack<>();
        while(head != null) {
            stack.push(head.val);
            if (stack.size() == k) {
                while(!stack.isEmpty()) {
                    if (first == null) {
                        first = new ListNode(stack.pop());
                        next = first;
                    } else {
                        next.next = new ListNode(stack.pop());
                        next = next.next;
                    }
                }
            }
            head = head.next;
        }
        List<Integer> list = stack.stream().collect(Collectors.toList());
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