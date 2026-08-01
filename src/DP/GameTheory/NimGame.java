package DP.GameTheory;

// ques: https://leetcode.com/problems/nim-game/description/?envType=problem-list-v2&envId=game-theory

// will form pattern
public class NimGame {
    public boolean canWinNim(int n) {
        if(n<4)
            return true;

        return n%4 != 0;

    }
}
