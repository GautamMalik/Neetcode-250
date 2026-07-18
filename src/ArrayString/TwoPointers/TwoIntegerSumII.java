package ArrayString.TwoPointers;

// ques: https://neetcode.io/problems/two-integer-sum-ii/question?list=neetcode250

public class TwoIntegerSumII {

    public int[] twoSum(int[] numbers, int target) {
        int l=0, r=numbers.length-1;
        while(l<r){
            int temp = numbers[l] + numbers[r];
            if(temp == target && numbers[l] != numbers[r])
                return new int[]{l+1, r+1};
            else if (temp < target) {
                l++;
            } else
                r--;
        }
        return new int[]{-1,-1};
    }
}
