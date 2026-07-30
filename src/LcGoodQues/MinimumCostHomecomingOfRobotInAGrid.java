package LcGoodQues;

// ques: https://leetcode.com/problems/minimum-cost-homecoming-of-a-robot-in-a-grid/

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinimumCostHomecomingOfRobotInAGrid {


    /// for this solution -> Go directly
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int startPosI= startPos[0], startPosJ=startPos[1];
        int endPosI = homePos[0], endPosJ =homePos[1];

        int ans = 0;
        if(startPosI < endPosI) {
            for (int i = startPosI + 1; i <= endPosI; i++)
                ans += rowCosts[i];
        } else{
            for (int i = startPosI - 1; i >= endPosI; i--)
                ans += rowCosts[i];
        }

        if(startPosJ<endPosJ){
            for(int j= startPosJ+1; j<=endPosJ; j++)
                ans += colCosts[j];
        } else{
            for(int j= startPosJ-1; j >= endPosJ; j--)
                ans += colCosts[j];
        }
        return ans;
    }

    /// DIJKSTRA ALGO -> fail due to constraint
    private static class Pair{
        int i;
        int j;
        int cost;

        Pair(int i, int j, int cost){
            this.i=i;
            this.j=j;
            this.cost=cost;
        }
    }
    public int minCostBetterDijkstra(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int startPosI= startPos[0], startPosJ=startPos[1];
        int endPosI = homePos[0], endPosJ =homePos[1];
        int m = rowCosts.length, n = colCosts.length;

        int[][] directions = new int[][]{
                {-1,0}, // up
                {1,0}, // down
                {0,-1}, // left
                {0,1} // right
        };

        int[][] costArr = new int[m][n];
        for(int[] i : costArr)
            Arrays.fill(i, (int)1e9);
        costArr[startPosI][startPosJ] = 0;
        Queue<Pair> pq = new PriorityQueue<>((a, b)-> a.cost-b.cost);
        pq.add(new Pair(startPosI,startPosJ,0));

        while(!pq.isEmpty()) {
            int i = pq.peek().i;
            int j = pq.peek().j;
            int cost = pq.peek().cost;
            pq.remove();

            if (cost > costArr[i][j])
                continue;

            if (i == endPosI && j == endPosJ)
                break;

            for(int[] dir : directions){
                int newI = i + dir[0];
                int newJ = j + dir[1];

                if(newI<0 || newI >= m || newJ <0 || newJ >=n)
                    continue;

                int newCost = cost;
                if(dir[0] == 1 || dir[0] == -1) // moving up or down
                    newCost += rowCosts[newI];
                else // moving left or right
                    newCost += colCosts[newJ];

                if(newCost < costArr[newI][newJ]){  // imp for dijkstra
                    costArr[newI][newJ] = newCost;
                    pq.add(new Pair(newI, newJ, newCost));
                }
            }
        }

        return costArr[endPosI][endPosJ];
    }
    public int minCostDijkstra(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int startPosI= startPos[0], startPosJ=startPos[1];
        int endPosI = homePos[0], endPosJ =homePos[1];
        int m = rowCosts.length, n = colCosts.length;

        int[][] costArr = new int[m][n];
        for(int[] i : costArr)
            Arrays.fill(i, (int)1e9);
        costArr[startPosI][startPosJ] = 0;
        Queue<Pair> pq = new PriorityQueue<>((a, b)-> a.cost-b.cost);
        pq.add(new Pair(startPosI,startPosJ,0));

        while(!pq.isEmpty()){
            int i = pq.peek().i;
            int j = pq.peek().j;
            int cost = pq.peek().cost;
            pq.remove();

            if(cost > costArr[i][j])
                continue;

            if(i == endPosI && j == endPosJ)
                break;

            // up
            if(i>0){
                int newCost = cost + rowCosts[i-1];
                if(newCost < costArr[i-1][j]){
                    costArr[i-1][j] = newCost;
                    pq.add(new Pair(i-1, j, newCost));
                }
            }

            // down
            if(i<m-1){
                int newCost = cost + rowCosts[i+1];
                if(newCost < costArr[i+1][j]){
                    costArr[i+1][j] = newCost;
                    pq.add(new Pair(i+1, j, newCost));
                }
            }

            // left
            if(j>0){
                int newCost = cost + colCosts[j-1];
                if(newCost < costArr[i][j-1]){
                    costArr[i][j-1] = newCost;
                    pq.add(new Pair(i,j-1,newCost));
                }
            }

            // right
            if(j<n-1){
                int newCost = cost + colCosts[j+1];
                if(newCost < costArr[i][j+1]){
                    costArr[i][j+1] = newCost;
                    pq.add(new Pair(i,j+1,newCost));
                }
            }
        }

        return costArr[endPosI][endPosJ];
    }
}
