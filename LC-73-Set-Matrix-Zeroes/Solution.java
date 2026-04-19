class Solution {
    public void setZeroes(int[][] matrix) {

    // Using set to store the rows/cols which contain zero, and then traverse again to update the matrix

        int m = matrix.length;
        int n = matrix[0].length;

        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j] == 0){
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(rows.contains(i) || cols.contains(j)){
                    matrix[i][j] = 0;
                } 
            }
        }

   }
}

/* Explanation:
1. Iterate over the matrix and whenever you find the element to be zero, add it's row number to a Row HashSet and add it's col number to a Col HashSet
2. We use these HashSets to determine which rows and cols should be set to zero
3. We cannot change it immediately, bcz then while iterating it further, we might mistakenly use wrong values as 0 (which we changed)
4. Now, iterate over the matrix again and check if your HashSet's, either row set contains current row number or col set contains current col number, then set it's current element which we are iterating to Zero.
5. Time - (M*N)
6. Space - O(M + N)
*/