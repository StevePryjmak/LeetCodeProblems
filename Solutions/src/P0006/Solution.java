package P0006;

class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        String ans="";
        int offset= 2*numRows - 2;
        for(int i = 0; i<numRows;i++){
            for(int j=i; j < s.length();j+=offset)
            {
                ans+=s.charAt(j);
                if(i!=0 && i!=numRows-1 && j+2*(numRows-i-1)<s.length())
                    ans += s.charAt(j+2*(numRows-i-1));
            }
        }
        return ans;
    }
}