package ArrayString.TwoPointers;

// ques: https://neetcode.io/problems/merge-strings-alternately/question?list=neetcode250

public class MergeStringsAlternately {
    public String mergeAlternately(String word1, String word2) {
        int l=0, r=0;
        StringBuilder sb = new StringBuilder();
        int temp=0;
        while(l<word1.length() && r<word2.length()){
            if(temp%2==0) {
                sb.append(word1.charAt(l));
                l++;
            } else{
                sb.append(word2.charAt(r));
                r++;
            }
            temp++;
        }

        while(l<word1.length()){
            sb.append(word1.charAt(l));
            l++;
        }
        while(r<word2.length()){
            sb.append(word2.charAt(r));
            r++;
        }

        return sb.toString();
    }
}
