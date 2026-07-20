package BackTracking;

// ques: https://neetcode.io/problems/subsets/question?list=neetcode250

import java.util.*;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        backtrack(0, nums, new ArrayList<>(), ans);
        return ans;
    }

    private void backtrack(int idx, int[] nums, ArrayList<Integer> tempAns, List<List<Integer>> ans) {
        if(idx== nums.length) {
            ans.add(new ArrayList<>(tempAns));
            return;
        }

        tempAns.add(nums[idx]);
        backtrack(idx+1,nums, tempAns,ans);
        tempAns.removeLast();
        backtrack(idx+1,nums,tempAns,ans);
    }
}
