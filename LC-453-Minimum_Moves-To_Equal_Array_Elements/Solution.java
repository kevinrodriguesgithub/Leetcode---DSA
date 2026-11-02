class Solution {
    public int minMoves(int[] nums) {
        
        int n = nums.length;

        int minVal = Integer.MAX_VALUE;

        for(int i: nums){
            minVal = Math.min(minVal, i);
        }

        int moves = 0;
        for(int i: nums){
            moves += (i - minVal);
        }
        return moves;
    }
}

/* Explanation
1. In one move, we increment n-1 elements by 1, which is same as decrement one remaining element in nums by 1
2. So, in one move we decrement one element of nums by 1
3. Now the question is, if we keep on decrementing each element of nums by 1, eventually we will reach our target number of steps when all elements are equal. ie when all elements are equal to the minimum element
4. Find out the minimum element of nums
5. Now, for each element in nums to reach the minimum element value, it will take that (num - minNum) steps
6. Calculate these steps for each element
7. The total number of moves is our answer
8. Time - O(n)
9. Space - O(1)
*/