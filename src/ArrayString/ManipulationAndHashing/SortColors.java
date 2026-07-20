package ArrayString.ManipulationAndHashing;

// ques: https://neetcode.io/problems/sort-colors/question?list=neetcode250

public class SortColors {

    public void sortColors(int[] nums) {
        int left=0, right= nums.length-1;

        while(left<=right && nums[left]==0)
            left++;

        while(right>=0 && nums[right]==2)
            right--;

        int k= left;
        while(k<= right){
            if(nums[k] == 0) {
                swap(left,k,nums);
                left++;
                k++;
            } else if (nums[k]==2) {
                swap(k,right,nums);
                right--;
            }else
                k++;
        }

    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        SortColors sortColors = new SortColors();
        sortColors.sortColors(new int[]{2,0,1,2,1,2,2});
    }
}
