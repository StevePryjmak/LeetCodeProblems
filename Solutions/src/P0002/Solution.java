package P0002;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode();
        int carry = 0;
        ListNode current = ans;
        while(l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = (int) sum/10;
            current.next = new ListNode(sum % 10);
            current = current.next;
        }
        return ans.next;
    }
}