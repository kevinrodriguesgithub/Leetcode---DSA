class Solution {
    public int minCostClimbingStairs(int[] cost) {
        
    // Approach 1
    /*    int n = cost.length;
        int dp[] = new int[n+1];    // [0,0,0,0]

        dp[n-1] = cost[n-1];        // [0,0,20,0]
        for(int i=n-2;i>=0;i--){
            dp[i] = cost[i] + Math.min(dp[i+1], dp[i+2]);
        }   // [25,15,20,0]

        return Math.min(dp[0], dp[1]);  */

    // Another method - dynamic programming

        int n = cost.length;
        int dp[] = new int[n];
        
        dp[0] = cost[0];
        dp[1] = cost[1];

        for(int i=2;i<n;i++){
            dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
        }
        return Math.min(dp[n-1], dp[n-2]);
    }
}

/* Explanation
1. We can start from index 0 or index 1
2. We need to calculate the cost to reach beyond the last step
3. Initialize a dp[] array, every index in this array will have the minimum cost yo jump beyond that index
4. Initialize dp[0] = cost[0] and dp[1] = cost[1], from constraints we know that the cost[] is atleast of length 2
5. Start the for loop from i=2, at every index the cost will be cost[i] at that index + Math.min(dp[i-1], dp[i-2])
6. Finally we will return the min cost from dp[n-1], dp[n-2] as we can jump over to the end from either last step or second last step
7. Time - O(n); Space - O(n)
*/