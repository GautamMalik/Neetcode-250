package ArrayString.Greedy;

// ques: https://neetcode.io/problems/boats-to-save-people/question?list=neetcode250

import java.util.Arrays;

public class BoatsToSavePeople {

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int l=0, r= people.length-1, ans=0;

        while (l<r){
            if(people[l] + people[r] <= limit){
                l++;
                r--;
            } else
                r--;
            ans++;
        }
        if(l==r)
            ans++;
        return ans;
    }

    public static void main(String[] args) {
        BoatsToSavePeople b = new BoatsToSavePeople();
        b.numRescueBoats(new int[]{5,1,4,2},5);
    }
}
