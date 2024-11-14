package P2064;

class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int start = 0;
        int end = quantities[0];

        for(int quantity: quantities) {
            end = Math.max(end, quantity);
        }

        while(start < end) {
            int middle = (start + end)/2;
            if(distribute(middle, quantities, n)) end = middle;
            else start = middle + 1;
        }
        return start;
    }

    private boolean distribute(int max, int[] quantities, int n){
        int j = 0;
        int remainder = quantities[j];
        for(int i = 0; i<n; i++) {

            if(remainder <= max) {
                j++;
                if(j == quantities.length) return true;
                else remainder = quantities[j];
            }
            else remainder -= max;
        }
        return false;
    }
}