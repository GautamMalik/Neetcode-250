package LcGoodQues;

// ques: https://leetcode.com/problems/smallest-divisible-digit-product-ii/description/

import java.util.List;

public class SmallestDivisibleDigitProduct2 {


    // video sol not mine
    public String smallestNumber(String num, long t) {
        int n = num.length();
        long tempT = t;
        for(int i : List.of(2,3,5,7)){
            while(tempT%i == 0)
                tempT= tempT/i;
        }
        if(tempT > 1)
            return "-1";

        long[] remainingFactor = new long[n+1];
        remainingFactor[0] = t;
        for(int i=0; i<n; i++){
            int digit = num.charAt(i) - '0';
            if(digit == 0)
                break;
            remainingFactor[i + 1] = remainingFactor[i]/gcd(remainingFactor[i], (long) digit);
        }

        if(remainingFactor[n] == 1)
            return num;

        int zeroPos = num.indexOf('0');
        int zeroIdx = n - 1;
        if (zeroPos != -1)
            zeroIdx = zeroPos;

        for(int i=zeroIdx; i>=0; i--){
            long required = remainingFactor[i];
            int freeSlot = n-1-i;

            for(int digit = num.charAt(i) - '0' + 1; digit<=9; digit++){
                long furtherRequired = required/gcd(required,digit);
                String requiredNum = func(furtherRequired,freeSlot);

                if(requiredNum.length() == freeSlot)
                    return num.substring(0,i) + (char)(digit + '0') + requiredNum;
            }
        }

        return func(t,n+1);
    }

    private String func(long required, int freeSlot) {
        StringBuilder sb = new StringBuilder();
        for(int i=9; i>=2; i--){
            while(required % i == 0) {
                sb.append((char) (i + '0'));
                required = required/i;
            }
        }

        while(sb.length() < freeSlot)
            sb.append("1");

        return sb.reverse().toString();
    }

    private long gcd(long a, long b) {
        while(b!=0){
            long temp = b;
            b = a%b;
            a= temp;
        }
        return a;
    }
}
