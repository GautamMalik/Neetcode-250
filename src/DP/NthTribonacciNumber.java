package DP;

// ques: https://neetcode.io/problems/n-th-tribonacci-number/question?list=neetcode250

import java.util.Arrays;

public class NthTribonacciNumber {
    public int tribonacci(int n) {
//        int[] dp = new int[n+1];
//        Arrays.fill(dp,-1);
//        return fun(n,dp);

        return funMemoized(n);
    }

    private int funMemoized(int n) {
        if(n==1 || n==2)
            return 1;
        if(n<=0)
            return 0;

        int[] dp = new int[n+1];
        dp[0] = 0; dp[1] = 1; dp[2] =1;
        for(int i=3; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        return dp[n];
    }

    private int fun(int n, int[] dp) {
        if(n==1 || n==2)
            return 1;
        if(n<=0)
            return 0;

        if(dp[n] != -1)
            return dp[n];

        return dp[n] = fun(n-1,dp) + fun(n-2,dp) + fun(n-3,dp);
    }
}
