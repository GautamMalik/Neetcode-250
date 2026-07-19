package DP;

public class HouseRobberII {

    public int rob(int[] nums) {
        if(nums.length==1)
            return nums[0];
        if(nums.length==2)
            return Math.max(nums[0],nums[1]);
        return Math.max(fun(0, nums.length-2,nums),fun(1, nums.length -1,nums));
    }

    private int fun(int start, int end, int[] nums) {
        int[] dp = new int[end-start+2];

        dp[end] = nums[end];
        dp[end-1] = Math.max(nums[end-1], nums[end]);

        if(end-start+1 == 2)
            return Math.max(dp[0],dp[1]);

        for(int i = end-2; i>=start; i--){
            dp[i] = Math.max(nums[i] + dp[i+2], dp[i+1]);
        }
        return dp[start];
    }

    public static void main(String[] args) {
        HouseRobberII h = new HouseRobberII();
        System.out.println(h.rob(new int[]{2,9,8,3,6}));
    }
}
