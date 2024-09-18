package P1310;

class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] prefixXor = new int[n], ans = new int[queries.length];
        prefixXor[0] = arr[0]; 
        for(int i = 1; i<n; i++) prefixXor[i] = prefixXor[i-1] ^ arr[i];

        for(int i = 0; i<queries.length;i++) {
            ans[i] = prefixXor[queries[i][1]];
            if(queries[i][0] != 0) 
                ans[i] ^=  prefixXor[queries[i][0] -1];
        }
        return ans;
    }
}