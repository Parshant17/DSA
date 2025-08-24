class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // Dummy node to handle edge cases easily
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode prev = dummy; 
        ListNode curr = head;
        
        while (curr != null) {
            // Detect duplicates
            if (curr.next != null && curr.val == curr.next.val) {
                // Skip all nodes with this value
                while (curr.next != null && curr.val == curr.next.val) {
                    curr = curr.next;
                }
                // Skip the duplicate block
                prev.next = curr.next;
            } else {
                prev = prev.next;
            }
            curr = curr.next;
        }
        
        return dummy.next;
    }
}

