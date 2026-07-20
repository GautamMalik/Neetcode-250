package Graph;

// ques: https://neetcode.io/problems/islands-and-treasure/question?list=neetcode250

import java.util.LinkedList;
import java.util.Queue;

public class IslandsAndTreasure {
    

    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 0) {
                    queue.offer(new int[]{i,j,0});
                }
            }
        }

        while(!queue.isEmpty()){
            int i = queue.peek()[0];
            int j = queue.peek()[1];
            int dist = queue.peek()[2];

            queue.remove();

            if(i<0 || j<0 || i>= grid.length || j>=grid[0].length || visited[i][j] || grid[i][j] == -1)
                continue;

            visited[i][j]=true;
            queue.offer(new int[]{i+1,j,dist+1});
            queue.offer(new int[]{i-1,j,dist+1});
            queue.offer(new int[]{i,j+1,dist+1});
            queue.offer(new int[]{i,j-1,dist+1});
            grid[i][j] = dist;
        }
    }

    public static void main(String[] args) {
        IslandsAndTreasure islandsAndTreasure = new IslandsAndTreasure();
        islandsAndTreasure.islandsAndTreasure(new int[][]{
                {2147483647, -1, 0, 2147483647},
                {2147483647, 2147483647, 2147483647, -1},
                {2147483647, -1, 2147483647, -1},
                {0, -1, 2147483647, 2147483647}
        });
    }
}
