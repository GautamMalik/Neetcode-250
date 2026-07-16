package ArrayString.ManipulationAndHashing;

// ques: https://neetcode.io/problems/anagram-groups/question?list=neetcode250

import java.util.*;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();

        for(String s : strs){
            int[] arr = new int[26];
            for(int i=0; i<s.length(); i++){
                arr[s.charAt(i) - 'a'] += 1;
            }
            String key = Arrays.toString(arr);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(s);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        groupAnagrams.groupAnagrams(new String[]{"act","pots","tops","cat","stop","hat"});
    }
}
