package DP;

import java.util.Arrays;

// ques: https://neetcode.io/problems/min-cost-climbing-stairs/question?list=neetcode250

public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length==1)
            return cost[0];
//        int[] dp = new int[cost.length+1];
//        Arrays.fill(dp,-1);
//        return Math.min(fun(cost.length - 1, cost, dp),
//                fun(cost.length - 2, cost, dp));
        return Math.min(funMemoized(cost.length - 1, cost),
                funMemoized(cost.length - 2, cost));
    }

    private int funMemoized(int n, int[] cost) {
        if(n<2)
            return cost[n];

        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];

        for(int i = 2; i<=n; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        return dp[n];
    }



    private int fun(int i, int[] cost, int[] dp) {
        if(i<2)
            return cost[i];

        if(dp[i] != -1)
            return dp[i];

        return dp[i] = Math.min(fun(i-1,cost,dp) , fun(i-2,cost,dp)) + cost[i];
    }

    public static void main(String[] args) {
        MinCostClimbingStairs minCostClimbingStairs = new MinCostClimbingStairs();
        minCostClimbingStairs.minCostClimbingStairs(new int[]{1,2,1,2,1,1,1});
    }
}
