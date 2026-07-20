package ArrayString.PrefixSum;

// ques: https://neetcode.io/problems/subarray-sum-equals-k/question?list=neetcode250

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map =new HashMap<>();
        map.put(0,1);
        int ans =0;
        int prefixSum=0;
        for(int i : nums){
            prefixSum += i;
            if(map.containsKey(prefixSum-k)){
                ans += map.get(prefixSum-k);
            }
            map.put(prefixSum , map.getOrDefault(prefixSum,0)+1);
        }
        return ans;
    }

    public static void main(String[] args) {
        SubarraySumEqualsK subarraySumEqualsK = new SubarraySumEqualsK();
        System.out.println(subarraySumEqualsK.subarraySum(new int[]{2,-1,1,2},2));
    }
}
