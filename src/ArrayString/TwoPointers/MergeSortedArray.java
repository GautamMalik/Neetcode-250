package ArrayString.TwoPointers;

// ques: https://neetcode.io/problems/merge-sorted-array/question?list=neetcode250

public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int l = 0, r=0;
        int[] ans = new int[m+n];
        int i=0;
        while(l<m && r<n){
            if(nums1[l] <= nums2[r]){
                ans[i] = nums1[l];
                l++;
            }
            else{
                ans[i] = nums2[r];
                r++;
            }
            i++;
        }

        while(l<m){
            ans[i] = nums1[l];
            i++;
            l++;
        }

        while(r<n){
            ans[i] = nums2[r];
            i++;
            r++;
        }
        for(int j=0; j< ans.length; j++){
            nums1[j] = ans[j];
        }
    }

    public static void main(String[] args) {
        MergeSortedArray mergeSortedArray = new MergeSortedArray();
        mergeSortedArray.merge(new int[]{10,20,20,40,0,0},4,new int[]{1,2},2);
    }
}
