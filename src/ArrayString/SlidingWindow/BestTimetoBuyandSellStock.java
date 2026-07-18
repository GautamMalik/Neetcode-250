package ArrayString.SlidingWindow;

// ques: https://neetcode.io/problems/buy-and-sell-crypto/question?list=neetcode250

public class BestTimetoBuyandSellStock {

    public int maxProfit(int[] prices) {
        int buyAt = 0;
        int ans = 0;

        for(int i=1; i<prices.length; i++){
            ans = Math.max(ans, prices[i] - prices[buyAt]);
            if(prices[i] < prices[buyAt])
                buyAt=i;
        }
        return ans;
    }
}
