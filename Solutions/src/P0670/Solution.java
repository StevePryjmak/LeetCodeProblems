package P0670;

class Solution {
    public int maximumSwap(int num) {
        char[] numStr = Integer.toString(num).toCharArray();
        int n = numStr.length;
        int maxDigitIndex = -1, index1= -1, index2 = -1;


        for(int i = n - 1; i>= 0; --i) {
            if(maxDigitIndex == -1 || numStr[i]>numStr[maxDigitIndex]) {
                maxDigitIndex = i;
            }
            else if(numStr[i] < numStr[maxDigitIndex]) {
                index1= i;
                index2 = maxDigitIndex;
            }
        }

        if(index1 != -1 && index2 != -1){
            char temp = numStr[index1];
            numStr[index1] = numStr[index2];
            numStr[index2] = temp;
        }

        return Integer.parseInt(new String(numStr));
    }
}