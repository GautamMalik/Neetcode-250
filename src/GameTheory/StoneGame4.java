package GameTheory;
// ques: https://leetcode.com/problems/stone-game-iv/description/?envType=problem-list-v2&envId=game-theory
public class StoneGame4 {

    public boolean winnerSquareGame(int n) {
        Boolean[][] dp = new Boolean[n+1][2];
        return solve(n,0,dp);
    }

    private boolean solve(int n, int turn, Boolean[][] dp) {
        if(n==0)
            return turn == 1;

        if(dp[n][turn]!=null) return dp[n][turn];

        if (turn == 0) {
            for (int i = 1; i * i <= n; i++) {
                if (solve(n - i * i, 1, dp)) {
                    return dp[n][turn] = true;
                }
            }
            return dp[n][turn] = false;

        } else {
            for (int i = 1; i * i <= n; i++) {
                if (!solve(n - i * i, 0, dp)) {
                    return dp[n][turn] = false;
                }
            }
            return dp[n][turn] = true;

        }
    }

    public static void main(String[] args) {
        StoneGame4 stoneGame4= new StoneGame4();
        System.out.println(stoneGame4.winnerSquareGame(7));
    }
}
