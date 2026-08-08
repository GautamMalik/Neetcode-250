package LcGoodQues;

// ques: https://leetcode.com/problems/find-the-lexicographically-smallest-valid-sequence/description/

public class FindLexicographicallySmallestValidSequence {

    public int[] validSequence(String word1, String word2) {
        int[] ans = new int[word2.length()];

        int left = word1.length() - 1, right = word2.length() - 1;

        int[] suffixMatch = new int[word1.length()];
        if (word1.charAt(word1.length() - 1) == word2.charAt(word2.length() - 1)) {
            suffixMatch[left] = 1;
            right--;
        } else
            suffixMatch[left] = 0;

        left--;
        while (left >= 0) {
            if (right >= 0 && word1.charAt(left) == word2.charAt(right)) {
                suffixMatch[left] = suffixMatch[left + 1] + 1;
                right--;
            } else {
                suffixMatch[left] = suffixMatch[left + 1];
            }
            left--;
        }

        left = 0;
        right = 0;

        boolean changed = false;

        while (left < word1.length() && right < word2.length()) {
            if (word1.charAt(left) == word2.charAt(right)) {
                ans[right] = left;
                left++;
                right++;
                continue;
            }
            if(!changed){
                int remaining = word2.length() - right - 1;
                if (left + 1 < word1.length() && suffixMatch[left + 1] >= remaining) {
                    ans[right] = left;
                    left++;
                    right++;
                    changed=true;
                    continue;
                }
            }
            left++;
        }
        if (right == word2.length()) {
            return ans;
        }

        return new int[0];    }

}
