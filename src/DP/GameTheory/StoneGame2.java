package DP.GameTheory;

// ques: https://leetcode.com/problems/stone-game-ii/description/?envType=problem-list-v2&envId=game-theory

import java.util.Arrays;

public class StoneGame2 {
    int n;
    public int stoneGameII(int[] piles) {
        n = piles.length;
        int[][] dp =new int[piles.length][piles.length*2];

        for(int[] i: dp)
            Arrays.fill(i,-1);

        int[] suffixSum = new int[piles.length];
        int sum = 0;
        for(int i= piles.length-1; i>=0; i--){
            suffixSum[i] = sum + piles[i];
            sum += piles[i];
        }

        return solve(piles,0, 1, dp,suffixSum);
    }

    private int solve(int[] piles, int i, int m, int[][] dp,int[] suffixSum) {
        if(i>=n) return 0;
        if(n-i <= 2*m) return suffixSum[i];
        if(dp[i][m] != -1) return dp[i][m];

        int ans =0;
        int idx=i,take=0;

        for(int k=1; k<=2*m; k++){
            // adding to alice score
            take += piles[idx];
            idx++;

//            calculating future alice score
            int temp = 1;
            int futureAliceScore = (int)1e9,  newM = Math.max(m, k);
            while(temp<=2*newM && temp<n){
                futureAliceScore = Math.min(futureAliceScore, solve(piles,i+k+temp, Math.max(newM,temp),dp, suffixSum));
                temp++;
            }

            // maximizing ans
            ans = Math.max(ans,take+futureAliceScore);
        }
        return  dp[i][m] = ans;
    }

    public static void main(String[] args) {
        StoneGame2 stoneGame2 = new StoneGame2();
        System.out.println(stoneGame2.stoneGameII(new int[]{1,2,3,4,5,100}));
    }
}
