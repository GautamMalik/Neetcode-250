package Graph;

import java.util.HashMap;
import java.util.Map;

//ques: https://neetcode.io/problems/verifying-an-alien-dictionary/question?list=neetcode250
public class VerifyingAnAlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0; i<order.length(); i++){
            map.put(order.charAt(i),i);
        }
        boolean br;
        for(int i=1; i< words.length; i++){
            String word1 = words[i-1];
            String word2 = words[i];
            br = false;
            int l=0, r=0;
            while(l<word1.length() && r<word2.length()){
                if(word1.charAt(l) == word2.charAt(r)){
                    l++;
                    r++;
                } else{
                    if(map.get(word1.charAt(l)) < map.get(word2.charAt(r))) {
                        br = true;
                        break;
                    }
                    else
                        return false;
                }
            }
            if(!br && i<word1.length()) return false;
        }
        return true;
    }
}
