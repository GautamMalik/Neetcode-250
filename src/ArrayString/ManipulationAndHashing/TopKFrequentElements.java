package ArrayString.ManipulationAndHashing;

// ques: https://neetcode.io/problems/top-k-elements-in-list/question?list=neetcode250

import java.util.HashMap;
import java.util.*;
import java.util.Queue;

public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int i : nums)
            map.put(i, map.getOrDefault(i,0)+1);

        Queue<Integer> q = new PriorityQueue<>((a,b)->map.get(b)-map.get(a));
        for(int i : map.keySet())
            q.offer(i);

        int [] ans = new int[k];
        for(int i=0; i<k; i++)
            ans[i] = q.poll();

        return ans;
    }
}
