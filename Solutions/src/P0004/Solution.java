package P0004;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int n1 = nums1.length, n2 = nums2.length;
        if (n1 > n2)
            return findMedianSortedArrays(nums2, nums1);
        int start = 0;

        int end = nums1.length;
        int left = (n1+n2+1)/2;
        while(start<=end)
        {
            int middle1 = (start+end)/2;
            int middle2 = left -middle1;

            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE, r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;
            
            if (middle1<n1) r1 = nums1[middle1];
            if (middle2<n2) r2 = nums2[middle2];
            if (middle1-1>= 0 ) l1 = nums1[middle1-1];
            if (middle2-1>= 0) l2 = nums2[middle2-1];

            if (l1 <= r2 && l2<= r1)
            {
                if ((n1+n2)%2 == 1) return Math.max(l1,l2);
                else return((double)(Math.max(l1,l2)+Math.min(r1,r2)))/2;
            }
            else if (l1>r2) end = middle1-1;
            else start = middle1 + 1;

        }
        return 0;
    }
    
}