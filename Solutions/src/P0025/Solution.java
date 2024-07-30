package P0025;

class Solution {
    public ListNode reverseKNodes(ListNode head, int k) {
        ListNode privious = null;
        ListNode current = head;
        ListNode next = null;

        for(int count = 0; current!= null && count<k; count++) {
            next = current.next;
            current.next = privious;
            privious = current;
            current = next;
        }
        return privious;

    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k==1) return head;
        ListNode result = new ListNode(0, head);
        ListNode privious = result;
        
        while(head != null) {
            ListNode start = privious.next;
            ListNode end = head;
            int count = 0;
            for(; count<k && end!=null; count++)
            end = end.next;
            if (count != k) return result.next;

            ListNode next = end;
            ListNode ReversedGroup = reverseKNodes(head, k);

            privious.next = ReversedGroup;
            start.next = next;

            privious = head;
            head = next; 


        }
        return result.next;
    }
}