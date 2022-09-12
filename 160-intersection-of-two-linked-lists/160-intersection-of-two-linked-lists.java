/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        var history = new HashSet<ListNode>();
        while(headA != null) {
            if(!history.contains(headA)) {
                history.add(headA);
                headA = headA.next;
            } else {
                break;
            }
        }
        
        while(headB != null) {
            if (history.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
}