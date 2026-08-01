package DP.GameTheory;
// ques: https://leetcode.com/problems/guess-number-higher-or-lower-ii/description/?envType=problem-list-v2&envId=game-theory

import java.util.Arrays;

public class GuessNumberHigherOrLowerII {

    public int getMoneyAmount(int n) {
        int[][] dp = new int[n+1][n+1];
        for(int[] p : dp)
            Arrays.fill(p,-1);

        return solve(n,1,n,dp);
    }

    private int solve(int n,int i, int j, int[][] dp) {
        if(i>=j)
            return 0;
        if(j-i == 1) return dp[i][j] = i;
        if(dp[i][j] != -1)
            return dp[i][j];

        int ans = (int) 1e9;
        for(int k = (i+j)/2; k<=j; k++){
            int guessLower = k + solve(n, k+1,j,dp);
            int guessHigher = k + solve(n, i,k-1,dp);
            ans = Math.min(ans, Math.max(guessHigher,guessLower));
        }
        return dp[i][j] = ans;
    }

    public static void main(String[] args) {
        GuessNumberHigherOrLowerII g = new GuessNumberHigherOrLowerII();
        System.out.println(g.getMoneyAmount(10));
    }
}
