package DP.GameTheory;
// ques:  https://leetcode.com/problems/predict-the-winner/description

// Game theory logic ->>>  minimax or maximin
// myBest = max or min( option1, option2)
// option = min or max( worst case scenario)
// Your turn → max(...) (or min(...) if you're minimizing a cost).
//        Opponent's turn → the opposite operation.


/**
 * 1) MaxiMin or Minimax
 * 2) Score -> when we have to find score take - other's move  -> return alice - bob score stone game 3
 * 3) turn -> add one more dimension to dp if turn == 1 alice move else bob
 * 4) Pair -> kind of turn, method will return alice and bob score (alice,bob)
 */

import java.util.Arrays;

// Do your best expect worst from other player / luck and return best(worst)
public class PredictTheWinner {

    public boolean predictTheWinner(int[] nums) {
        if(nums.length<3)
            return true;

        int[][] dp = new int[nums.length][nums.length];
        for(int[] i : dp)
            Arrays.fill(i,-1);
        int score1stPlayer = solve(nums,0,nums.length-1, dp);
        return score1stPlayer >= Arrays.stream(nums).sum() - score1stPlayer;
    }

    private int solve(int[] nums, int i, int j, int[][] dp) {
        if(i == j)
            return nums[i];
        if(i>j)
            return 0;
        if(dp[i][j] != -1)
            return dp[i][j];

        int takeLeft = nums[i] + Math.min(solve(nums,i+1,j-1,dp), solve(nums,i+2,j,dp));
        int takeRight = nums[j] + Math.min(solve(nums,i+1,j-1,dp), solve(nums,i, j-2,dp));

        return dp[i][j] = Math.max(takeLeft, takeRight);
    }

    /**
            {1,3,90,7}
            -> your best either take 1 or 7 --> take 1 => {3,90,7}
                                                take 7 => {1,3,90}

            after 2nd player turn you will get --> {3,90} or {90,7} --> 2nd player smart ==> i'll get {3,90} [3,90 is worst or min one]
                                                --> {1,3} or {3,90} -->                 ==>           {1,3} [1,3 is worst one or min one]

            so i'll return best(worst) ==>
            worst ==> min[(3,90),(90,7)]        ||||  min([1,3)(3,90))
            my turn 1+ min[(3,90),(90,7)]     |||| 7 + min([1,3)(3,90))

            --> i'll return max(1+ min[(3,90),(90,7)], 7 + min([1,3)(3,90)))
     **/
}
