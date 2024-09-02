package P1894;

class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long[] prefixSum = new long[chalk.length];
        long currentSum = 0;
        for (int i = 0; i < chalk.length; i++) {
            prefixSum[i] = currentSum;
            currentSum += chalk[i];
        }
        k %= currentSum;
        int start = 0;
        int end = chalk.length;
        while (start < end) {
            int middle = start + (end - start) / 2;
            if (prefixSum[middle] <= k) {
                start = middle + 1;
            } else {
                end = middle;
            }
        }
        return start;
    }
}