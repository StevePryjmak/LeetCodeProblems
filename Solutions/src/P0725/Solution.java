package P0725;

class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        if(k == 0) return new ListNode[0];
        ListNode[] ans = new ListNode[k];
        int size = 0;
        ListNode temp = head;
        while(temp != null) {
            size++;
            temp = temp.next;
        }
        int numInEach = size /k;
        int numOfRemParts = size %k;
        temp = head;
        
        for(int i = 0; i<k; i++)
        {
            temp = head;
            ans[i] = head;
            int numToSkip = numInEach;
            if(numOfRemParts != 0) {
                numToSkip ++;
                numOfRemParts --;
            }
            for(int j = 0; j<numToSkip-1;j++) temp = temp.next;
            if(temp != null)
            {
                head = temp.next;
                temp.next = null;                
            }

        }

        return ans; 
    }
}