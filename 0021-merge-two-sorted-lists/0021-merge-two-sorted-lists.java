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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res = null;
        ListNode next = null;
        while(list1 != null || list2 != null) {
            if (list1 == null) {
                if (res == null) {
                    res = new ListNode(list2.val);
                    next = res;
                } else {
                    next.next = new ListNode(list2.val);
                    next = next.next;
                }
                list2 = list2.next;
                continue;
            }
            if (list2 == null) {
                if (res == null) {
                    res = new ListNode(list1.val);
                    next = res;
                } else {
                    next.next = new ListNode(list1.val);
                    next = next.next;
                }
                list1 = list1.next;
                continue;
            }
            if (list1.val > list2.val) {
                if (res == null) {
                    res = new ListNode(list2.val);
                    next = res;
                } else {
                    next.next = new ListNode(list2.val);
                    next = next.next;
                }
                list2 = list2.next;
            } else {
                if (res == null) {
                    res = new ListNode(list1.val);
                    next = res;
                } else {
                    next.next = new ListNode(list1.val);
                    next = next.next;
                }
                list1 = list1.next;
            }
        }
        return res;
    }
}