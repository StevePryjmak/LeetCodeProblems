package P0042;

class Solution {
    public int trap(int[] height) {
        if (height.length == 0) return 0;
        int[] left= new int[height.length];
        int[] right = new int[height.length];
        int max = height[0];
        for(int i = 0; i < height.length; i++) 
        {
            if(height[i] > max) max = height[i];
            left[i] = max;
        }
        max = height[height.length-1];
        for(int i = height.length-1; i>=0; i--) 
        {
            if(height[i] > max) max = height[i];
            right[i] = max;
        }
        
        int result = 0;
        for(int i = 0; i<height.length;i++) {
            result+= Math.min(right[i], left[i]) -height[i];
        }
        return result;
    }
}