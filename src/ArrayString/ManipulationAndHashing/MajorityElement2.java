package ArrayString.ManipulationAndHashing;

// ques: https://neetcode.io/problems/majority-element-ii/question?list=neetcode250

import java.util.*;

public class MajorityElement2 {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }

        int threshold = nums.length/3;

        for(Map.Entry<Integer,Integer> temp : map.entrySet()){
            if(temp.getValue() > threshold)
                ans.add(temp.getKey());
        }
        return ans;
    }
}
