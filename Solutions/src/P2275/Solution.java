package P2275;

class Solution {
    public int largestCombination(int[] candidates) {
        int max = 0;
        for(int i = 0; i<24; i++){
            int current_bits_count = 0;
            for(int num: candidates) {
                if((num & (1 << i)) != 0) current_bits_count++; 
            }
            max = Math.max(max, current_bits_count);
        }
        return max;
    }
}
