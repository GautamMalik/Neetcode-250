package ArrayString.ManipulationAndHashing;

// ques: https://neetcode.io/problems/duplicate-integer/question?list=neetcode250

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int i : nums){
            if(set.contains(i))
                return true;
            set.add(i);
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate containsDuplicate = new ContainsDuplicate();
        containsDuplicate.hasDuplicate(new int[]{1,2,3,3});
    }
}
