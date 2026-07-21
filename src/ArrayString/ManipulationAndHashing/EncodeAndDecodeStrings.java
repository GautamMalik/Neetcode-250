package ArrayString.ManipulationAndHashing;

// ques: https://neetcode.io/problems/string-encode-and-decode/question?list=neetcode250

import java.util.*;

public class EncodeAndDecodeStrings {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String i: strs){
            sb.append("#").append(i.length()).append(';');
            sb.append(i);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();

        int i=0;
        while(i<str.length()){
            i++;
            StringBuilder length = new StringBuilder();
            while (i < str.length() && str.charAt(i) != ';') {
                length.append(str.charAt(i));
                i++;
            }
            i++;
            int len = Integer.parseInt(length.toString());
            ans.add(str.substring(i, i + len));
            i += len;
        }

        return ans;
    }

    public static void main(String[] args) {
        EncodeAndDecodeStrings encodeAndDecodeStrings = new EncodeAndDecodeStrings();
        System.out.println(encodeAndDecodeStrings.decode(encodeAndDecodeStrings.encode(List.of("0"))));
    }
}
