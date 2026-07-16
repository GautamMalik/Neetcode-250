package ArrayString.ManipulationAndHashing;

public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        boolean hasOne = false;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 1) hasOne = true;
            if(nums[i]<=0 || nums[i] > nums.length) nums[i] = 1;
        }

        if(!hasOne)
            return 1;

        for(int i=0; i< nums.length; i++){
            int curr = Math.abs(nums[i]);
            int idx = curr-1;
            if(nums[idx]>0){
                nums[idx] = -nums[idx];
            }
        }

        for(int i=0; i< nums.length; i++){
            if(nums[i] >0)
                return i+1;
        }

        return nums.length+1;
    }

    /// ////////////////////////////
    ///
    public int firstMissingPositive2(int[] nums) {
        for(int i=0; i<nums.length; i++){
            if(nums[i]<=0){
                nums[i] = Integer.MAX_VALUE;
            }
        }
        int i=0;
        while(i<nums.length){
            if(i == nums[i]-1 || i==Integer.MAX_VALUE){
                i++;
                continue;
            }

            while(i != nums[i] - 1 && nums[i] != Integer.MAX_VALUE){
                if(!swap(i,nums[i]-1, nums))
                    break;
            }
            i++;
        }

        for(int k=0; k< nums.length; k++){
            if(k+1 != nums[k])
                return k+1;
        }
        return nums.length+1;
    }

    private boolean swap(int i, int j, int[] nums) {
        if(i>= nums.length || j>= nums.length || nums[i]==nums[j])
            return false;
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        return true;
    }


    public static void main(String[] args) {
        FirstMissingPositive firstMissingPositive = new FirstMissingPositive();
        System.out.println(firstMissingPositive.firstMissingPositive(new int[]{1,2,3,4,5}));
    }
}
