package Graph;

// ques: https://neetcode.io/problems/count-number-of-islands/question?list=neetcode250

import java.util.LinkedList;
import java.util.Queue;

public class NumberofIslands {

    public int numIslands(char[][] grid) {

        int ans = 0;
        for(int i = 0; i< grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] != '*' && grid[i][j] == '1'){
                    bfs(i,j,grid);
                    ans++;
                }
            }
        }
        return ans;
    }

    private void bfs(int i1, int j1, char[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i1, j1});
        while(!q.isEmpty()){

            int[] cell = q.poll();
            int i = cell[0];
            int j = cell[1];
            if(i<0 || j<0 || i >= grid.length || j>= grid[0].length || grid[i][j]=='0' || grid[i][j]=='*')
                continue;
            grid[i][j] = '*';

            q.offer(new int[]{i + 1, j});
            q.offer(new int[]{i - 1, j});
            q.offer(new int[]{i, j + 1});
            q.offer(new int[]{i, j - 1});
        }
    }

    private void dfs(int i, int j, char[][] grid) {
        if(i<0 || j<0 || i >= grid.length || j>= grid[0].length || grid[i][j]=='0' || grid[i][j]=='*')
            return;

        grid[i][j] = '*';
        dfs(i+1,j,grid);
        dfs(i-1,j,grid);
        dfs(i,j+1,grid);
        dfs(i,j-1,grid);
    }

    public static void main(String[] args) {
        NumberofIslands numberofIslands = new NumberofIslands();
        numberofIslands.numIslands(new char[][]{
                {'0', '1', '1', '1', '0'},
                {'0', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        });
    }
}
