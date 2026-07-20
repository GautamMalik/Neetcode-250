package ArrayString.PrefixSum;

public class RangeSumQuery2DImmutable {

    int[][] prefixSum;

    public RangeSumQuery2DImmutable(int[][] matrix) {
        int preSum=0;
        prefixSum = new int[matrix.length][matrix[0].length];
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                preSum += matrix[i][j];
                prefixSum[i][j] = preSum;
            }
        }
    }
    // 0,0  3,4
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int ans = 0;
        for(int i =row1; i<=row2; i++){
            if(col1>0 )
                ans += prefixSum[i][col2] - prefixSum[i][col1-1];
            else if(i>0)
                ans += prefixSum[i][col2] - prefixSum[i-1][prefixSum[0].length-1];
            else
                ans += prefixSum[i][col2];
        }
        return ans;
    }

    public static void main(String[] args) {
        RangeSumQuery2DImmutable rangeSumQuery2DImmutable = new RangeSumQuery2DImmutable(new int[][]{
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        });
        rangeSumQuery2DImmutable.sumRegion(0,0,3,4);
        rangeSumQuery2DImmutable.sumRegion(2, 1, 4, 3);
        rangeSumQuery2DImmutable.sumRegion(1,1,2,2);
        rangeSumQuery2DImmutable.sumRegion(1, 2, 2, 4);
        rangeSumQuery2DImmutable.sumRegion(0, 0, 2, 2);


    }
}
