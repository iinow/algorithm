/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func detectCycle(head *ListNode) *ListNode {
    m := make(map[ListNode]bool)
	for {
        if head == nil {
            return nil
        }
		_, ok := m[*head]
		if !ok {
			m[*head] = true
			head = head.Next
		} else {
			return head
		}
	}
}