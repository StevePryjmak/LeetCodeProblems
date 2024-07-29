package P0023;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        return binaryKListsMerge(lists, 0, lists.length-1);
    }
    public ListNode binaryKListsMerge(ListNode[] lists, int start, int end) {
        if (start == end) return lists[start];
        if (start + 1 == end) return mergeTwoLists(lists[start],lists[end]);

        int middle = start + (end- start)/2;
        ListNode leftPart = binaryKListsMerge(lists, start, middle);
        ListNode rightPart = binaryKListsMerge(lists, middle + 1, end);
        return mergeTwoLists(leftPart,rightPart);
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