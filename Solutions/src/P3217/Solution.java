package P3217;

import java.util.HashSet;
import java.util.Set;
class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i< nums.length; i++) set.add(nums[i]);

        ListNode temp = new ListNode(0, head);
        ListNode curr = temp;
        while(curr.next != null) {
            if(!set.contains(curr.next.val)) curr = curr.next;
            else curr.next = curr.next.next;
        }
        return temp.next;
    }
}