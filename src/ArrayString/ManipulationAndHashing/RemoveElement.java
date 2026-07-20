package ArrayString.ManipulationAndHashing;

// ques: https://neetcode.io/problems/remove-element/question?list=neetcode250

public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        boolean broke = false;
        int ans = 0;
        for(int i=0; i< nums.length; i++) {
            if(nums[i]==val) {
                for(int j=i+1; j< nums.length; j++) {
                    if(nums[j] != val) {
                        swap(i, j, nums);
                        broke = true;
                        break;
                    }
                }
                if(!broke)
                    break;
            }
            broke = false;
            ans++;
        }
        return ans;
    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /// /////////////////////////
    public int removeElementThierBEst(int[] nums, int val) {
       int k=0;
       for(int i=0; i< nums.length; i++){
           if(nums[i]!=val){
               nums[k] = nums[i];
               k++;
           }
       }
       return k;
    }

    public static void main(String[] args) {
        RemoveElement removeElement= new RemoveElement();
        removeElement.removeElementThierBEst(new int[]{0,1,2,2,3,0,4,2},2);
    }
}
