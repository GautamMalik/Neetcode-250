package ArrayString.TwoPointers;

// ques: https://neetcode.io/problems/max-water-container/question?list=neetcode250

public class ContainerWithMostWater {

    public int maxArea(int[] heights) {
        int l=0, r= heights.length-1;
        int ans =0;
        while(l<r){
            ans = Math.max(ans, Math.min(heights[l], heights[r]) * (r - l));

            if(heights[l] < heights[r])
                l++;
            else
                r--;
        }
        return ans;
    }
}
