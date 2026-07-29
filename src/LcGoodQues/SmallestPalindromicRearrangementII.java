package LcGoodQues;

// https://leetcode.com/problems/smallest-palindromic-rearrangement-ii/description/

// see how to calculate kth permutation for distinct and duplicate values

// Approach one  (My)
// -> take first half and mid --> find kth permutation of first half
// -->  return kthPermuation of 1st half + mid + reverse of kThPermutation
// -> failed as string was having duplicates values and i calculated kth permutaion for distinct by n! eg abcd -> total permutaion is 24
// --> string has duplicate so permutition is calculated as eg. aabbccdeee -> n!/(2! * 2! * 2! * 1! * 3!) -> below ones are duplicated char freq

// Approach Two (Chat Gpt)
// I calculated factorial till 1st half length and calculated kth permutation
// --> failed as 1st half length can go till 10^2 --> integer, long, biginteger overflow -> TLE

// Approach 3 (Video)
// calculated total permutation by eg. aabbccdeee -> nC2 * n-2C2 * n-2-2C2 * n-2-2-2C2 * n-2-2-2-1C1 * n-2-2-2-1-3C3
// nC2 = n*n-1/ 2*1
// again value overflow for 10^2 1st half case

// approach 4 (ChatGpt)
// added limit in calculation total permitutaion -> limit = k --> if ans > limit --> return limit + 1
// passed

public class SmallestPalindromicRearrangementII {

    int[] freq = new int[26];
    public String smallestPalindrome(String s, int k) {

        int n = s.length();
        String oddChar = "";
        if((n&1) == 1)
            oddChar += s.charAt(n/2);

        for(int i=0; i<n/2; i++){
            freq[s.charAt(i)-'a'] += 1;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i< freq.length; i++){
            int temp = freq[i];
            while(temp>0){
                sb.append((char) (i + 'a'));
                temp--;
            }
        }

        long total = getTotalPermutation(sb.length(),k);

        if(k>total)
            return "";
        StringBuilder ans = getKthPermuatationWithDuplicateValues(sb, k);
        return ans + oddChar + ans.reverse();
    }

    private long getTotalPermutation(int length, long limit) {
        long ways =1;
        for(int i: freq){
            if(i>0){
                ways = ways * nCr(length,i,limit);
                if (ways > limit)
                    return limit + 1;
                length = length - i;
            }
        }
        return ways;
    }

    private long nCr(int n, int r, long limit) {
        if (r < 0 || r > n) return 0;
        r = Math.min(r, n - r);

        long res = 1;
        for (int i = 1; i <= r; i++) {
            res = res * (n - r + i) / i;
            if (res > limit)
                return limit + 1;

        }
        return res;
    }

    private StringBuilder getKthPermuatationWithDuplicateValues(StringBuilder str, long k) {
        int n = str.length();
        StringBuilder ans = new StringBuilder();
        while(n>0) {
            for(int i=0; i< freq.length; i++) {
                if(freq[i]>0) {
                    freq[i]--;
                    long totalWays = getTotalPermutation(n-1,k);
                    if (k>totalWays) {
                        k = k- totalWays;
                        freq[i]++;
                    }else {
                        ans.append((char) (i + 'a'));
                        n--;
                        break;
                    }
                }
            }
        }
        return ans;
    }

    /// /////////////////

//    private StringBuilder getKthPermuatation(StringBuilder str, int k, int[] fact) {
//        if (str.isEmpty())
//            return new StringBuilder();
//
//        int n = str.length();
//        int block = fact[n - 1];   eg 1234 -> 4! -> block size = 3!
//
//        int index = (k - 1) / block;   // to avoid if k==block size
//
//        char ch = str.charAt(index);
//        str.deleteCharAt(index);
//
//        return new StringBuilder()
//                .append(ch)
//                .append(getKthPermuatation(str, (k - 1) % block + 1, fact));
//    }
}
