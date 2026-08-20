class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
     /*   int m = grid.length;
        int n = grid[0].length;

        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                map.put(grid[i][j], map.getOrDefault(grid[i][j], 0) +1);
            }
        }

        int ans[] = new int[2];
        for(int i=1;i<=m*m;i++){
            if(map.containsKey(i)){
                if(map.get(i) == 2)
                    ans[0] = i;
            }
            else{
                ans[1] = i;
            }
        }
        return ans;     */
    
    // 
        int n = grid.length;
        int m = grid[0].length;

        int rangeMax = n*n;
        Set<Integer> set = new HashSet<>();
        int ans[] = new int[2];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int num = grid[i][j];
                if(set.contains(num)){
                    ans[0] = num;
                }
                set.add(num);
            }
        }

        for(int i=1;i<=n*n;i++){
            if(!set.contains(i)){
                ans[1] = i;
            }
        }
        return ans;
    }
}

/* Explanation
1. The range of values is from 1 to n*n
2. We can start iterating over the matrix values, and while iterating add that value to a HashSet
3. Before adding we will check if the set already contains this value. If it does, it means this is the value which appears twice. Store it in ans[0]
4. Once we have finished iterating over the matrix, the set contains all the values from 1 to n*n except the one value which is not present. Now we need to find this value.
5. In a for loop, iterate from 1 to n*n, and for every value check if the set doesn't contain that value, then that value should be stored at ans[1].
6. Time - O(n^2)
7. Space - O(n^2)
*/