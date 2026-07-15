package BackTracking;

// ques: https://neetcode.io/problems/combination-target-sum/question?list=neetcode250

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        fun(0, target, new ArrayList<Integer>(), nums, ans);
        return ans;
    }

    private void fun(int i, int target, ArrayList<Integer> tempAns, int[] nums, List<List<Integer>> ans) {
        if(i == nums.length){
            if(target==0)
                ans.add(new ArrayList<>(tempAns));
            return;
        }

        // pick
        if(nums[i]<=target){
            tempAns.add(nums[i]);
            fun(i,target-nums[i],tempAns,nums,ans);
            tempAns.removeLast();  // using list so need to remove
        }

        // not-pick
        fun(i+1,target,tempAns,nums,ans);
    }
}
