package Heap;

// ques: https://neetcode.io/problems/last-stone-weight/question?list=neetcode250

import java.util.PriorityQueue;
import java.util.Queue;

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> pq = new PriorityQueue<>((a,b)->b-a);

        for(int i: stones)
            pq.offer(i);

        while(pq.size()>1){
            int a = pq.remove();
            int b = pq.remove();

            if(a!=b)
                pq.offer(Math.abs(a-b));
        }
        return pq.size()==1? pq.peek() : 0;
    }
}
