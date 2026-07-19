package DP;

// ques: https://neetcode.io/problems/house-robber/question?list=neetcode250

import java.util.Arrays;
import java.util.HashMap;

public class HouseRobber {

    public int rob(int[] nums) {
//        int[] dp = new int[nums.length + 1];
//        Arrays.fill(dp,-1);
//        return fun(0, nums, dp);

        return funMemoizedBetter(nums);
    }

    private int fun(int idx, int[] nums, int[] dp) {
        if(idx >= nums.length)
            return 0;

        if(dp[idx] != -1)
            return dp[idx];

        int take = nums[idx] + fun(idx+2, nums, dp);
        int notTake = fun(idx+1, nums, dp);

        return dp[idx] = Math.max(take,notTake);
    }

    private int funMemoized(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        int[] dp = new int[nums.length];
        dp[nums.length-1] = nums[nums.length-1];
        dp[nums.length-2] = nums[nums.length-2];

        if(nums.length == 2)
            return Math.max(dp[0],dp[1]);

        for(int i= nums.length-3; i>=0; i--){
            int take = nums[i] + dp[i+2];
            int notTake = dp[i+1];
            dp[i] = Math.max(take,notTake);
        }
        return dp[0];
    }

    // Not working
    private int funMemoizedBetter(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        int nextIdx=0,secnextIdx=0, ans=0;
        nextIdx = nums[nums.length-1];
        secnextIdx = Math.max(nums[nums.length - 2], nums[nums.length - 1]);

        if(nums.length == 2)
            return Math.max(nextIdx, secnextIdx);

        for(int i= nums.length-3; i>=0; i--){
            ans = Math.max(nums[i] + secnextIdx,nextIdx);
            nextIdx = secnextIdx;
            secnextIdx = ans;
        }
        return ans;
    }


    public static void main(String[] args) {
        HouseRobber houseRobber = new HouseRobber();
        houseRobber.rob(new int[]{1,2,1,1});
    }
}
