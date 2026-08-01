package DP.GameTheory;

// ques: https://leetcode.com/problems/stone-game/description/?envType=problem-list-v2&envId=game-theory

import java.util.Arrays;

public class StoneGame {
    public boolean stoneGame(int[] piles) {
        int[][] dp = new int[piles.length][piles.length];
        for(int[] i: dp) Arrays.fill(i,-1);
        int scoreAlice = solve(piles,0,piles.length-1, dp);
        return scoreAlice > Arrays.stream(piles).sum() - scoreAlice;
    }

    private int solve(int[] piles, int i, int j, int[][] dp) {
        if(i==j) return piles[i];
        if(i>j) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int takeStart = piles[i] + Math.min(solve(piles,i+2,j,dp),solve(piles,i+1,j-1,dp));
        int takeEnd = piles[j] + Math.min(solve(piles,i+1,j-1,dp),solve(piles,i,j-2,dp));

        return dp[i][j] = Math.max(takeStart,takeEnd);
    }
}
