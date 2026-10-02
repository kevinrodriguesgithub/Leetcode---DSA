class Solution {
    public int diagonalSum(int[][] mat) {
    
    // Time - O(n)
        int n = mat.length;
       // int m = mat[0].length;  // no need as n == m bcz it's a square matrix

        int sum = 0;
        for(int i=0;i<n;i++){

            sum += mat[i][i];       // primary diagonal
            
            sum += mat[i][n-1 -i];  // secondary diagonal
        }       // [0,2] [1,1] [2,0] for 3x3
                // [0,3] [1,2] [2,1] [3,0] for 4x4
        if(n%2 == 1){
            sum -= mat[n/2][n/2];   // if n is odd, the center element was added twice, so subtract it
        }
        return sum;     

    // Time - O(n^2)  
    /*    int n = mat.length;
       // int m = mat[0].length;  // no need as n == m bcz it's a square matrix

        int sum = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i == j){             // part of primary diagonal
                    sum += mat[i][j];
                }
                if(i!=j && (i+j) == n-1){   // secondary diagonal
                    sum += mat[i][j];
                }
            }
        }       // [0,2] [1,1] [2,0] for 3x3
                // [0,3] [1,2] [2,1] [3,0] for 4x4
        return sum;     */   
    }
}

/* Explanation
1. It is a square matrix, so rows and columns would be equal
2. Initialize a sum variable which will store the sum count
3. For primary diagonal, the indices would be [0,0], [1,1], [2,2]....and so on
    So indices would be [i,i]
4. For secondary diagonal the indices would be for eg: 4x4 matrix, [0,3], [1,2], [2,1], [3,0]
    For 3x3 it will be [0,2], [1,1], [2,0]
    So we can infer that the indices will be [i][n-1 -i]
5. Now, we can compute the sum in a single for loop
6. for primary diagonal add sum += mat[i][i]
7. For secondary diagonal, add sum += mat[i][n-1 -i];
8. One thing we have check is that if n is odd, then middle element would be counted in primary as well as secondary matrix, 
So check if n is odd, if it is, then subtract the mat[n/2][n/2] from the sum
9. Finally return the sum
10. Time - O(n); Space - O(1) 
*/