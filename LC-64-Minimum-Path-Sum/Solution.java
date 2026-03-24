class Solution {
    public int minPathSum(int[][] grid) {
        
    // 1st method
    /*    int m = grid.length;
        int n = grid[0].length;

        int dp[][] = new int[m][n];
        dp[0][0] = grid[0][0];      // top-left

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i == 0 && j > 0){        // for 1st row (top most)
                    dp[0][j] = dp[0][j-1] + grid[0][j];
                }
                else if(j == 0 && i > 0){   // for 1st column (left most)
                    dp[i][0] = dp[i-1][0] + grid[i][0];
                }
                else if(i>0 && j>0){   // means i > 0 && j > 0
                    dp[i][j] = grid[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);   // add curr value of [i][j] with min from left and above 
                }
            }
        }
        return dp[m-1][n-1];
            */

    // 2nd method - Space optimized - No extra space

        int m = grid.length;
        int n = grid[0].length;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i == 0 && j == 0){   // 1st cell skip it
                    continue;
                }
                if(i == 0){ // 1st row
                    grid[i][j] += grid[i][j-1];     // curr value + left value
                }
                else if(j == 0){ // 1st col
                    grid[i][j] += grid[i-1][j];     // curr value + top value
                }
                else{   // not a 1st row and not a 1st col
                    grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
                }
            }
        }
        return grid[m-1][n-1];
    }
}

/* Explanation
1. We will use Dynamic programming concept here
2. From every cell we can either move to right or down
3. For every cell, the minimum cost to reach it, is it's current value + minimum value from left cell or top cell
4. For 1st row, we will calculate the cost of every cell to it's right
5. Simillarly, for 1st col, we will calculate the cost of every cell to it's bottom
6. For rest of the cells, we will use the cell's current value and minimum among (cell on it's top, cell on it's left) and that will determine the minimum cost to reach the current cell
7. At the end of our iteration, in the right bottom corner, we will have our minimum cost to reach the destination cell
*/