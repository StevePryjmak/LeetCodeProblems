package P3043;

class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        TrieNode root = new TrieNode();
        for(int num: arr1) root.addNum(num, false);
        for(int num: arr2) root.addNum(num, true);
        return root.maxHeight;
    }

    private class TrieNode {
        TrieNode[] childs = new TrieNode[10];  // Changed to size 10 to cover digits 0-9
        int maxHeight = 0;
        boolean fromArr1 = false;
        boolean fromArr2 = false;

        TrieNode() {}

        public void addNum(int num, boolean isArr2) {
            TrieNode curr = this;
            String str = Integer.toString(num);
            int i = 0;
            for (char c : str.toCharArray()) {
                i++;
                int index = c - '0';
                if (curr.childs[index] == null) {
                    curr.childs[index] = new TrieNode();
                }
                curr = curr.childs[index];

                if (isArr2)  curr.fromArr2 = true;
                else curr.fromArr1 = true;
                
                if (curr.fromArr1 && curr.fromArr2) {
                    maxHeight = Math.max(i, maxHeight);
                }
            }
        }
    }
}