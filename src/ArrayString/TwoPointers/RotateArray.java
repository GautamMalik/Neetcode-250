package ArrayString.TwoPointers;

// ques: https://neetcode.io/problems/rotate-array/question

public class RotateArray {

    public void rotateBestTheir(int[] nums, int k) {
        k = k%nums.length;
        int n = nums.length-1;
        reverse(0,n,nums);
        reverse(0,k-1,nums);
        reverse(k,n,nums);
    }

    private void reverse(int i, int j, int[] nums) {
        while(i<j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

    public void rotateMy(int[] nums, int k) {
        if(k>nums.length)
            k = k%nums.length;
        int[] kArr = new int[k];
        int p=0, q = nums.length-1;
        for(int i= 0; i<k; i++){
            kArr[p] = nums[q];
            p++;
            q--;
        }

        for(int j= nums.length-k-1; j>=0; j--){
            nums[j+k] = nums[j];
        }

        p=0;
        for(int j= k; j>0; j--){
            nums[j-1] = kArr[p];
            p++;
        }
    }

    public static void main(String[] args) {
        RotateArray rotateArray= new RotateArray();
        rotateArray.rotateBestTheir(new int[]{1,2,3,4,5},3);
    }


    public void rotateMyBrute(int[] nums, int k) {

        for(int i=0; i<k; i++){

            int temp = nums[nums.length-1];

            for(int j= nums.length-2; j>=0; j--){
                nums[j+1] = nums[j];
            }
            nums[0] = temp;
        }
    }
}
