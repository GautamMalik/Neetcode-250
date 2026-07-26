package DP;
// quess: https://neetcode.io/problems/best-time-to-buy-and-sell-stock-ii/question?list=neetcode250

import java.util.Arrays;

public class BestTimetoBuyandSellStock2 {

    //Their
    public int maxProfitTheir(int[] prices) {
        int res = 0;
        for(int i=1; i<prices.length; i++) {
            if(prices[i] > prices[i-1])
                res += (prices[i] - prices[i-1]);

        }
        return res;
    }

    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return fun(0, 1, dp, prices);
    }

    private int fun(int idx, int canBuy, int[][] dp, int[] prices) {
        if(idx == prices.length)
            return 0;

        if(dp[idx][canBuy] != -1)
            return dp[idx][canBuy];

        if (canBuy == 1) {
            int buy = -prices[idx] + fun(idx + 1, 0, dp, prices);
            int skip = fun(idx + 1, 1, dp, prices);

            return dp[idx][canBuy] = Math.max(buy, skip);
        } else {
            int sell = prices[idx] + fun(idx + 1, 1, dp, prices);
            int hold = fun(idx + 1, 0, dp, prices);

            return dp[idx][canBuy] = Math.max(sell, hold);
        }
    }
}
