class ListNode {
  val: number
  next: ListNode | null
  constructor(val?: number, next?: ListNode | null) {
    this.val = val === undefined ? 0 : val
    this.next = next === undefined ? null : next
  }
}

function addTwoNumbers(
  l1: ListNode | null,
  l2: ListNode | null
): ListNode | null {
  let child: ListNode | null = null
  let parent: ListNode | null = null
  let sin = false
  while (true) {
    if (!l1) {
      l1 = new ListNode(0)
    }
    if (!l2) {
      l2 = new ListNode(0)
    }
    const a = l1.val ? l1.val : 0
    const b = l2.val ? l2.val : 0
    const sum = a + b + (sin ? 1 : 0)
    sin = false

    if (sum > 9) {
      sin = true
    }

    if (!child) {
      parent = new ListNode(Number(sum.toString().slice(-1)))
      child = parent
    } else {
      child.next = new ListNode(Number(sum.toString().slice(-1)))
      child = child.next
    }

    if (!l1.next && !l2.next) {
      if (sin) {
        child.next = new ListNode(1)
      }
      break
    }

    l1 = l1.next
    l2 = l2.next
  }
  return parent
}
const l1 = new ListNode(2, new ListNode(4, new ListNode(3)))
const l2 = new ListNode(5, new ListNode(6, new ListNode(4)))
console.log(addTwoNumbers(l1, l2))
