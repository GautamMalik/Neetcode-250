package DP;

import java.util.Arrays;

// ques: https://neetcode.io/problems/climbing-stairs/question?list=neetcode250

public class ClimbingStairs {

    public int climbStairs(int n) {
//        int[] dp = new int[n+1];
//        Arrays.fill(dp,-1);
//        return fun(n,dp);
        return funMemoized(n);
    }

    private int fun(int n, int[] dp) {
        if(n<3)
            return n;
        if(dp[n] != -1)
            return dp[n];
        return dp[n] = fun(n-1,dp) + fun(n-2,dp);
    }

    private int funMemoized(int n) {
        if(n<2)
            return n;
        int[] dp = new int[n+1];
        dp[1] = 1; dp[2]=2;
        for(int i=3; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
