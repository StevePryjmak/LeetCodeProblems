package P0003;

import java.util.HashMap;


// it works but it is not best idea to use hashmap 
// use set to check if symbol is unique
class Solution {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("au"));
    }
    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int a=0; a<=127; a++)
            map.put((char) a, -1);
        if (s.length() == 0) return 0;
        map.put(s.charAt(0), 0);
        int max = 1,i=0, j=0;
        for(;;)
        {
            if(j<s.length()-1)
            {            
                if(map.get(s.charAt(j+1)) != -1 && max< j+1-i) max = j+1-i;
                j++;
            }
            else break;
            for(;i<=map.get(s.charAt(j));i++) map.put(s.charAt(i), -1);
            map.put(s.charAt(j),j);
        }
        if(max < j-i+1) max = j-i+1;
        return max;
    }
}