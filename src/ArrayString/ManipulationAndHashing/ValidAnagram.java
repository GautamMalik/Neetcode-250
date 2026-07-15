package ArrayString.ManipulationAndHashing;

// ques: https://neetcode.io/problems/is-anagram/question?list=neetcode250

import java.util.HashMap;

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0; i< s.length(); i++){
            char c =s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }

        for(int i=0; i< t.length(); i++){
            char c =t.charAt(i);
            if(!map.containsKey(c) || map.get(c) == 0)
                return false;
            map.put(c,map.get(c)-1);
        }
        return true;
    }

    public static void main(String[] args) {
        ValidAnagram validAnagram = new ValidAnagram();
        validAnagram.isAnagram("jar","jam");
    }
}
