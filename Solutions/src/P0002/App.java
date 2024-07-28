package P0002;
public class App {
    public static void main(String[] args) throws Exception {
        Solution s = new Solution();
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode result = s.addTwoNumbers(l1, l2);
        while(result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
