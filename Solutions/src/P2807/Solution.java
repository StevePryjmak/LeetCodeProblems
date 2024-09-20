package P2807;


class Solution {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head == null) return head;
        ListNode prev = head, next = head.next;
        while(next != null) {
            int gcd = calculateGCD(prev.val, next.val);
            ListNode gcdNode = new ListNode(gcd, next);
            prev.next = gcdNode;
            prev=next;
            next = prev.next;
        }
        return head;
    }

    public int calculateGCD(int a, int b) {
        while(b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}