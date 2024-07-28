package P0005;

class Solution {
    public static String AddHashes(String s) {
        String ret_str = "";
        for(int i=0; i<s.length(); i++)
            ret_str += "#" + s.charAt(i);
        ret_str += "#";
        return ret_str;
    }
    public String longestPalindrome(String s) {
        if(s.length() == 0) return "";
        s = AddHashes(s);
        int center=0, right=0, centerOfMax= 1;
        int p[] = new int[s.length()];
        for(int i=0; i<s.length(); i++)
        {
            int mirror = 2*center - i;
            if(right > i) p[i] = Math.min(p[mirror], right - i);
            else p[i] = 0;

            while(  (i+p[i]+1<s.length() && i-p[i]-1>=0 ) && s.charAt(i+p[i]+1) == s.charAt(i-p[i]-1))
                p[i]++;
            
            if(p[i] > p[centerOfMax]) centerOfMax = i;
            
            if(i+p[i]>right) 
            {
                right = i + p[i];
                center = i;
            }
        }
        String ans = "";
        for(int i = centerOfMax-p[centerOfMax]; i<=centerOfMax+p[centerOfMax];i++)
        if(s.charAt(i) != '#') ans+= s.charAt(i);
        return ans;
    }
}