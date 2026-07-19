package ArrayString.Greedy;

// ques: https://neetcode.io/problems/lemonade-change/question?list=neetcode250

import java.util.*;

public class LemonadeChange {

    public boolean lemonadeChangeTheir(int[] bills) {
        int five=0, ten=0;
        for(int i : bills){
            if(i==5)
                five++;
            if(i == 10){
                ten++;
                if(five>0)
                    five--;
                else
                    return false;
            }
            if(i==20){
                if(five >=3)
                    five -= 3;
                else if (five>=1 && ten>=1) {
                    five--;
                    ten--;
                } else
                    return false;
            }
        }
        return true;
    }


    public boolean lemonadeChange(int[] bills) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(5,0);
        map.put(10,0);
        map.put(20,0);
        for(int i : bills){
            map.put(i, map.getOrDefault(i,0)+1);
            if(i == 10){
                if(map.get(5) >0)
                    map.put(5,map.get(5)-1);
                else
                    return false;
            }
            if(i==20){
                if(map.get(5) >=3)
                    map.put(5, map.get(5)-3);
                else if (map.get(5)>=1 && map.get(10)>=1) {
                    map.put(10, map.get(10)-1);
                    map.put(5, map.get(5)-1);
                } else
                    return false;
            }
        }
        return true;
    }
}
