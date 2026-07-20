package ArrayString.ManipulationAndHashing;

import java.util.*;

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        Map<Integer,Boolean> map = new HashMap<>();
        for(int i: nums)
            map.put(i,false);

        int ans =0;
        for(int i : nums){
            map.put(i,true);
            int tempAns = 0;
            int tempI = i+1;
            while(map.containsKey(tempI) && !map.get(tempI)){
                map.put(tempI,true);
                tempI++;
                tempAns++;
            }
            tempI = i-1;
            while(map.containsKey(tempI) && !map.get(tempI)){
                map.put(tempI,true);
                tempI--;
                tempAns++;
            }

            ans = Math.max(ans,tempAns);
        }
        return ans;
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence longestConsecutiveSequence= new LongestConsecutiveSequence();
        longestConsecutiveSequence.longestConsecutive(new int[]{2,20,4,10,3,4,5});
    }
}
