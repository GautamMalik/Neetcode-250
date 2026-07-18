package ArrayString.SlidingWindow;

// ques: https://neetcode.io/problems/contains-duplicate-ii/question?list=neetcode250

import java.util.*;
import java.util.Map;

public class ContainsDuplicateII {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        if(nums.length == 1){
            if(k==0)
                return true;
            else
                return false;
        }

        int r=1;
        map.put(nums[0],0);

        while(r< nums.length){
            if(map.containsKey(nums[r]) && Math.abs(map.get(nums[r]) - r)<=k)
                return true;
            map.put(nums[r],r);
            r++;
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicateII containsDuplicateII = new ContainsDuplicateII();
        containsDuplicateII.containsNearbyDuplicate(new int[]{1,0,1,1},1);
    }

}
