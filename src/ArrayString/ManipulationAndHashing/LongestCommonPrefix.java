package ArrayString.ManipulationAndHashing;

// ques: https://neetcode.io/problems/longest-common-prefix/question

import java.util.Arrays;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);

        int i=0,j=0;

        String a = strs[0];
        String b= strs[strs.length-1];

        String ans = "";
        while(i<a.length() && j<b.length()){
            if(a.charAt(i) != b.charAt(j))
                break;
            ans += a.charAt(i);
            i++;
            j++;
        }
        return ans;
    }
}
