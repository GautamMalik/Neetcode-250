package ArrayString.ManipulationAndHashing;

//ques : https://leetcode.com/problems/concatenation-of-array/

public class ConcatenationOfArray {
    public int[] getConcatenation(int[] nums) {
        int[] ans = new int[nums.length * 2];

        for(int i=0; i< nums.length; i++){
            ans[i] = ans[i+ nums.length] = nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        ConcatenationOfArray concatenationOfArray = new ConcatenationOfArray();
        concatenationOfArray.getConcatenation(new int[]{1,4,1,2});
    }
}
