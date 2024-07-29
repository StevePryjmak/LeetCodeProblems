package P0021;

class Solution {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4, new ListNode(5, new ListNode(6)))));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode ans = new Solution().mergeTwoLists(list1, list2);
        while(ans != null) {
            System.out.print(ans.val + " ");
            ans = ans.next;
        }
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode ans = new ListNode(0);
        ListNode temp = ans;
        while(list1 != null && list2 != null)
        {
            if(list1.val < list2.val) {
                temp.next = list1;
                list1 = list1.next; 
            }
            else {
                temp.next = list2;
                list2 = list2.next; 
            }
            temp = temp.next;
        }
        if(list1 != null) temp.next = list1;
        else if(list2 != null) temp.next = list2;
        return ans.next;
    }
}