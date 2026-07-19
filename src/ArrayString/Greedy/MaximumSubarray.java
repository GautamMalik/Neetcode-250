package ArrayString.Greedy;

// ques: https://neetcode.io/problems/maximum-subarray/question

public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int sum=0, ans=Integer.MIN_VALUE;
        for(int i : nums){
            sum += i;
            ans = Math.max(ans, sum);
            if(sum<0)
                sum=0;
        }
        return ans;
    }
}
