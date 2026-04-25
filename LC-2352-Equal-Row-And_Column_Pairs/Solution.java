class Solution {
    public int equalPairs(int[][] grid) {
        
        int n = grid.length;

        Map<List<Integer>, Integer> rowMap = new HashMap<>();

        for(int i=0;i<n;i++){
            List<Integer> list = new ArrayList<>();
            for(int j=0;j<n;j++){
                int curr = grid[i][j];
                list.add(curr);
            }
            rowMap.put(list, rowMap.getOrDefault(list, 0) +1);
        }

        int count = 0;
        for(int i=0;i<n;i++){
            List<Integer> list = new ArrayList<>();
            for(int j=0;j<n;j++){
                int curr = grid[j][i];
                list.add(curr);
            }
            if(rowMap.containsKey(list)){
                count += rowMap.get(list);
            }
        }
        return count;

    /*    int n = grid.length; // column size will also be n as per the prob desc

        Map<List<Integer>, Integer> rowMap = new HashMap<>();
        int pairs = 0;
        // Logic: row are stored in a map and then iterate over col and check the rowMap if it contains the same
        for(int i=0;i<n;i++){
            List<Integer> row = new ArrayList<>();
            for(int j=0;j<n;j++){
                int val = grid[i][j];
                row.add(val);       // <3,2,1>
            }
            rowMap.put(row, rowMap.getOrDefault(row, 0) +1);  // {<3,2,1>, 1; <1,7,6>, 1; <2,7,7>, 1}
        }

        for(int i=0;i<n;i++){
            List<Integer> col = new ArrayList<>();
            for(int j=0;j<n;j++){
                int val = grid[j][i];
                col.add(val);       // <3,1,2>
            }
            if(rowMap.containsKey(col)){
                pairs += rowMap.get(col);   // Eg1: <2,7,7> will get match
            }
        }
        return pairs;       */
    }
}

/* Explanation:
1. First iterate over the rows and store each row as a key in a HashMap (rowMap)
2. Now, iterate over the columns and over each set of a column, check if the set of column is present in the rowMap, if it is, then it forms a pair. 
3. We use ArrayList here because it maintains the insertion order
4. When we find that set of column is present in rowMap, we add the occurences of that set of row to our answer, because consider row 2 has 2,3,4 and column 1 has 2,3,4 and column 3 also has 2,3,4. So these are two different pairs, row 2 - column 1, and row 2 - column3
5. After iterating over the columns, you will have your answer.
*/