package P0011;

class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length-1, area = 0;
        while(left < right) {
            int len = Math.min(height[left], height[right]);
            int base = right - left;
            area = Math.max(area, len * base);
            while(height[left] <= len && left < right) left++;
            while(height[right] <= len && left < right) right--;
        }
        return area;
    }
}
