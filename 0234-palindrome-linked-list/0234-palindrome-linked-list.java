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
    public boolean isPalindrome(ListNode head) {
        List<Integer> res = new ArrayList<>();
        
        while (head != null) {
            res.add(head.val);
            head = head.next;
        }
        
        for (int i = 0; i < res.size() / 2; i++) {
            if (res.get(i) != res.get(res.size() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}