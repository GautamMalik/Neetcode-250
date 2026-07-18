package ArrayString.TwoPointers;

// ques: https://neetcode.io/problems/remove-duplicates-from-sorted-array/question?list=neetcode250

import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        int ans = 0;
        int prevEle = -101;
        int idx =0;
        for(int i : nums){
            if(i != prevEle){
                nums[idx] = i;
                prevEle = i;
                ans++;
                idx++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray removeDuplicatesFromSortedArray = new RemoveDuplicatesFromSortedArray();
        removeDuplicatesFromSortedArray.removeDuplicates(new int[]{1,1,2,2,3,3,4});
    }
}
