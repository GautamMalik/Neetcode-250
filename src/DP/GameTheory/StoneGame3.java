package DP.GameTheory;

// ques: https://leetcode.com/problems/stone-game-iii/description/?envType=problem-list-v2&envId=game-theory

import java.util.Arrays;

public class StoneGame3 {
    public String stoneGameIII(int[] stoneValue) {
        int[] dp = new int[stoneValue.length];
        Arrays.fill(dp, -1);
//        int scoreAlice = solve(stoneValue, 0, dp);
//        int scoreBob = Arrays.stream(stoneValue).sum() - scoreAlice;
//        if (scoreAlice > scoreBob)
//            return "Alice";
//        else if (scoreAlice < scoreBob)
//            return "Bob";
//        else
//            return "Tie";

        int diff = solveByScore(stoneValue, 0, dp);

        if (diff > 0)
            return "Alice";
        else if (diff < 0)
            return "Bob";
        else
            return "Tie";
    }

    private int solve(int[] stoneValue, int i, int[] dp) {
        if (i >= stoneValue.length) return 0;
        if (dp[i] != -1) return dp[i];
        int take = 0, idx = i, ans = (int)-1e9;;
        for (int k = 1; k < 4 && idx < stoneValue.length; k++) {
            take += stoneValue[idx];
            idx++;
            int temp = 1;
            int futureAliceScore = (int) 1e9;
            while (temp < 4) {
                futureAliceScore = Math.min(futureAliceScore, solve(stoneValue, i + k + temp, dp));
                temp++;
            }
            ans = Math.max(ans, take + futureAliceScore);
        }
        return dp[i] = ans;
    }

    private int solveByScore(int[] stoneValue, int i, int[] dp) {
        if (i >= stoneValue.length) return 0;
        if (dp[i] != -1) return dp[i];
        int take = 0, ans = (int)-1e9;
        for (int k = 0; k < 3  && i+k < stoneValue.length; k++) {
            take += stoneValue[i+k];
            ans = Math.max(ans, take - solveByScore(stoneValue,i+k+1,dp));
        }
        return dp[i] = ans;
    }

    public static void main(String[] args) {
        StoneGame3 stoneGame3 = new StoneGame3();
        System.out.println(stoneGame3.stoneGameIII(new int[]{1,2,3,6}));
    }
}
