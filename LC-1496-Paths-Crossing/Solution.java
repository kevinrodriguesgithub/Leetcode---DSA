class Solution {
    public boolean isPathCrossing(String path) {
        int n = path.length();

        Set<List<Integer>> visited = new HashSet<>();
        int X = 0, Y = 0;
        visited.add(Arrays.asList(X, Y));

        for(int i=0;i<n;i++){
            char ch = path.charAt(i);   
            switch(ch){
                case 'N':
                    Y++;
                    break;
                case 'S':
                    Y--;
                    break;
                case 'E':
                    X++;
                    break;
                case 'W':
                    X--;
                    break;
            }
            boolean added = visited.add(Arrays.asList(X, Y));   // adding it outside switch, bcz we need to add it for either of all four conditions
            if(!added){ // added is false, it means duplicate entry, so was not added, the point overrlaps
                return true;
            }
        }
        return false;
    }
}


/* Explanation
1. We want to check if path crosses itself, it means if a particular index (x and y coordinate is already visited)
2. Start by creating a visited Set<> which will store the x,y coordinates of points which are visited by the path
3. Iterate over the string path, and based upon the condition N, E, S, W - Move the X and Y pointers and add that coordinate to the visited set.
4. We are adding it outside of the switch statement, because if either of the four conditions, we need to add it, so instead of writing it for all four conditions, I am writing it ouside of switch.
5. Now, try to add this coordinates to the visited Set
6. If it gets added succesfully, boolean added variable is receive true value, if it receives false, it means entry for those coordinates was already present and hence the path overlaps/crosses, Return the answer as True
7. After iterating over the entire String path, if all the coordinates were succesfully added, then return False as paths do not cross
*/