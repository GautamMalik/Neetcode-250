package ArrayString.ManipulationAndHashing;

//ques: https://neetcode.io/problems/majority-element/question?list=neetcode250

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    public int majorityElement(int[] nums) {
        int maj =0, ans=0;
        Map<Integer, Integer> map =new HashMap<>();
        for(int i: nums){
            map.put(i,map.getOrDefault(i,0)+1);
            if(maj < map.get(i)) {
                maj = map.get(i);
                ans = i;
            }
        }
        return ans;
    }

    public int majorityElement2(int[] nums) {
        int count =0, ans=0;
        for(int i: nums){
            if(count==0){
                ans = i;
            }
            count = count +  i==ans ? 1 : -1;
        }
        return ans;
    }

    public static void main(String[] args) {
        MajorityElement majorityElement = new MajorityElement();
        majorityElement.majorityElement2(new int[]{3,3,4});
    }
}
