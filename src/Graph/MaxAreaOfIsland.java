package Graph;

// ques: https://neetcode.io/problems/max-area-of-island/question?list=neetcode250

public class MaxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 1)
                    ans = Math.max(ans,dfs(i,j,grid));
            }
        }
        return ans;
    }

    private int dfs(int i, int j, int[][] grid) {
        if(i<0 || j<0 || i>= grid.length || j>= grid[0].length || grid[i][j] != 1)
            return 0;

        grid[i][j] = -1;
        return dfs(i, j-1 ,grid) + dfs(i, j+1 ,grid) + dfs(i+1, j ,grid) + dfs(i-1, j ,grid) + 1;
    }
}
