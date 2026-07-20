package ArrayString.ManipulationAndHashing;

// ques: https://neetcode.io/problems/string-encode-and-decode/question?list=neetcode250

import java.util.*;

public class EncodeAndDecodeStrings {

    private String seperator = ",";

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String i: strs){
            sb.append(i);
            sb.append(seperator);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        return Arrays.asList(str.split(seperator));
    }

    public static void main(String[] args) {
        EncodeAndDecodeStrings encodeAndDecodeStrings = new EncodeAndDecodeStrings();
        System.out.println(encodeAndDecodeStrings.decode(encodeAndDecodeStrings.encode(List.of(""))));
    }
}
