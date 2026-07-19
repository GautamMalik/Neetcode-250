package DP;

// ques: https://neetcode.io/problems/longest-palindromic-substring/question?list=neetcode250

public class LongestPalindromicSubstring {

    // will not work failed (abacbdcaba) only solution below one or expand around center) -> this is not dp
    // but idea is for every char try expand left and right and check if pallindrome and is capabale
    // of ans then update and.
    // check this expansion for even and odd length both
    // so for 1 index 2 expansion loops -> even and odd
    public String longestPalindrome(String s) {
        String reversed = new StringBuilder(s).reverse().toString();
        String ans = "";
        String[][] dp = new String[s.length()+1][s.length()+1];

        for(int i=0; i<s.length(); i++){
            for(int j=0; j<s.length(); j++){
                if(s.charAt(i) == reversed.charAt(j)){
                    if(i>0 && j>0 && dp[i-1][j-1]!=null)
                        dp[i][j] = dp[i-1][j-1] + s.charAt(i);
                    else
                        dp[i][j] = "" + s.charAt(i);
                    if(dp[i][j].length() > ans.length())
                        ans = dp[i][j];
                }
            }
        }

        return ans;
    }


    /// ///////////////////////
    Boolean[][] dp;
    public String longestPalindrome2(String s) {
        String ans = "";
        dp = new Boolean[s.length()+1][s.length()+1];
        for(int i=0; i<s.length(); i++){
            for(int j=i; j<s.length(); j++){
                if(j-i+1 > ans.length() && dfs(i,j,s))
                    ans = s.substring(i, j+1);
            }
        }
        return ans;
    }

    private boolean dfs(int i, int j, String substring) {
        if(i>=j)
            return dp[i][j] = true;
        if(substring.charAt(i) != substring.charAt(j))
            return dp[i][j] = false;
        if(dp[i][j] != null)
            return dp[i][j];

        return dp[i][j] = dfs(i+1,j-1,substring);
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring l = new LongestPalindromicSubstring();
        System.out.println(l.longestPalindrome("abaabac"));
    }
}
