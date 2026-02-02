
public class ListNode {

    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }
}

class Solution {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseList(head.next);

        head.next.next = head;
        head.next = null;

        return newHead;
    }
}
// 1. RECURSE: Dive to the end. newHead will be the original tail.

// 2. THE FLIP: (head.next) is my neighbor. 
// Make my neighbor's next-pointer point back to me.
// 3. THE CUT: Set my own next-pointer to null. 
// This breaks the old forward link and prevents cycles.
        // 4. RETURN: Pass the new start of the list back up the stack.
