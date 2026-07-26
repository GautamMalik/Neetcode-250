package LcGoodQues;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

// ques: https://leetcode.com/problems/minimum-cost-path-with-alternating-directions-iii/description/


// Dijkstra Algo -> before pushing to queue check if better distance then push otherwise not
public class MinimumCostPathWithAlternatingDirections3 {

    private static class Pair{
        int i;
        int j;
        long cost;
        int parity;


        Pair(int i, int j, long cost, int parity){
            this.i = i;
            this.j = j;
            this.cost = cost;
            this.parity = parity;
        }
    }
    public long minCost(int m, int n, int[][] penalty) {
        long[][][] costArr = new long[m][n][2];
        for(long[][] i : costArr) {
            for(long[] j : i)
                Arrays.fill(j, Long.MAX_VALUE);
        }
        costArr[0][0][1] = 1;
        Queue<Pair> pq = new PriorityQueue<>((a, b)-> Long.compare(a.cost, b.cost));
        pq.offer(new Pair(0,0,1l, 1));
        while(!pq.isEmpty()){
            Pair pair = pq.remove();
            int i = pair.i;
            int j = pair.j;
            long cost = pair.cost;
            int parity = pair.parity;

            if(cost > costArr[i][j][parity])
                continue;
            int nextParity = parity ^ 1;

            if((parity & 1) ==1){
                // go to allowed direction -> down & right
                if(i+1<m) {
                    long newCost = cost + getCost(i + 1, j);
                    if (newCost < costArr[i + 1][j][nextParity]) {  // ******
                        costArr[i + 1][j][nextParity] = newCost;
                        pq.offer(new Pair(i + 1, j, newCost, nextParity));
                    }
                }

                if(j+1<n) {
                    long newCost = cost + getCost(i, j+1);
                    if (newCost < costArr[i][j+1][nextParity]) {
                        costArr[i][j+1][nextParity] = newCost;
                        pq.offer(new Pair(i, j + 1, newCost, nextParity));
                    }
                }

                // wait
                if(cost + penalty[i][j] < costArr[i][j][nextParity]) {
                    costArr[i][j][nextParity] = cost + penalty[i][j];
                    pq.offer(new Pair(i, j, cost + penalty[i][j], nextParity));
                }

                // take panalty and go -> up & left
                if(i-1>=0) {
                    long newCost = cost + getCost(i-1, j) + penalty[i][j];
                    if(newCost < costArr[i-1][j][nextParity]) {
                        costArr[i-1][j][nextParity] = newCost;
                        pq.offer(new Pair(i - 1, j, newCost, nextParity));
                    }
                }
                if(j-1>=0) {
                    long newCost = cost + getCost(i, j-1) + penalty[i][j];
                    if(newCost < costArr[i][j-1][nextParity]) {
                        costArr[i][j-1][nextParity] = newCost;
                        pq.offer(new Pair(i, j - 1, newCost, nextParity));
                    }
                }
            }else {
                // go to allowed direction -> left & up
                if (i - 1 >= 0) {
                    long newCost = cost + getCost(i - 1, j);
                    if (newCost < costArr[i - 1][j][nextParity]) {
                        costArr[i - 1][j][nextParity] = newCost;
                        pq.offer(new Pair(i - 1, j, newCost, nextParity));
                    }
                }

                if(j-1>=0) {
                    long newCost = cost + getCost(i, j-1);
                    if (newCost < costArr[i][j-1][nextParity]) {
                        costArr[i][j-1][nextParity] = newCost;
                        pq.offer(new Pair(i, j - 1, newCost, nextParity));
                    }
                }

                // wait
                if (cost + penalty[i][j] < costArr[i][j][nextParity]) {
                    costArr[i][j][nextParity] = cost + penalty[i][j];
                    pq.offer(new Pair(i, j, cost + penalty[i][j], nextParity));
                }

                // take panalty and go -> down and right
                if (i + 1 < m) {
                    long newCost = cost + getCost(i + 1, j) + penalty[i][j];

                    if (newCost < costArr[i + 1][j][nextParity]) {
                        costArr[i + 1][j][nextParity] = newCost;
                        pq.offer(new Pair(i + 1, j, newCost, nextParity));
                    }
                }

                if (j + 1 < n) {
                    long newCost = cost + getCost(i, j + 1) + penalty[i][j];

                    if (newCost < costArr[i][j + 1][nextParity]) {
                        costArr[i][j + 1][nextParity] = newCost;
                        pq.offer(new Pair(i, j + 1, newCost, nextParity));
                    }
                }           }
        }

        return Math.min(costArr[m-1][n-1][0], costArr[m-1][n-1][1]);

    }

    private long getCost(int i, int j) {
        return (long) (i + 1) * (j+1);
    }

    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        MinimumCostPathWithAlternatingDirections3 m = new MinimumCostPathWithAlternatingDirections3();
        System.out.println(m.minCost(4,3,new int[][]{
                {1,0,5},
                {9,1,0},
                {2,0,5},
                {1,7,1}
        }));
    }
}
