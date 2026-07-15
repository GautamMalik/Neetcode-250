package ArrayString.BinarySearch;

// ques: https://neetcode.io/problems/sqrtx/question?list=neetcode250

public class SqrtX {
    public int mySqrt(int x) {
        if(x<2)
            return x;
        int l=0, r=x>>1;
        int tempAns = 0;
        while(l<=r){
            int mid = l + (r - l) / 2;
            long temp = (long) mid *mid;
            if(temp == x)
                return mid;
            else if(temp<x) {
                tempAns = mid;
                l = mid + 1;
            }
            else
                r = mid-1;
        }
        return tempAns;
    }
}
