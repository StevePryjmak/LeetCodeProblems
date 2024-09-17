package P0884;

import java.util.*;

class Solution {
    HashMap<String, Boolean> map = new HashMap<>();
    public String[] uncommonFromSentences(String s1, String s2) {
        ArrayList<String> words = new ArrayList<>();
        addWords(s1);
        addWords(s2);
        for (String key : map.keySet())
            if(!map.get(key)) words.add(key);
        return words.toArray(new String[0]);
    }

    public void addWords(String s) {
        String[] words = s.split(" ");
        for(String word: words) map.put(word, map.containsKey(word));
    }
}