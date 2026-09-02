class Solution {
    public int minimumDeletions(int[] nums) {
     // 0   1, 5   7   
        int n = nums.length;
        if(n == 1){
            return 1;
        } 
        int steps = 0;    

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int minIndex = -1, maxIndex = -1;

        for(int i=0;i<n;i++){
            if(nums[i] > max){
                max = nums[i];
                maxIndex = i;
            }
            if(nums[i] < min){
                min = nums[i];
                minIndex = i;
            }
        }

        int leftSide = Math.max(minIndex, maxIndex) - 0 + 1;
        int rightSide = (n-1) - Math.min(minIndex, maxIndex) + 1;

        int minLeftRight = Math.min(leftSide, rightSide);

        int bothSide = (Math.min(minIndex, maxIndex) - 0 + 1) + ((n-1) - Math.max(minIndex, maxIndex) +1);
       
        steps = Math.min(minLeftRight, bothSide);
        return steps;
    }
}

/* Explanation
1. All the elements in the array are distinct
2. One edge case is n == 1, so in that case return 1, as there's only 1 element and so minmum and maximum would be same
3. If n > 1, the minimum and maximum would be at two different indexes
4. Iterate through the array and find the minimum and maximum, also note down their indexes
5. Now there are three possible scenarios, 
    i. we remove both of them from left end
    ii. we remove both of them from right end
    iii. we remove leftmost from left end, and rightmost form right end
6. Amongst, these three scenarios, calculate the minimum steps
7. For left side, the number of steps would be the rightmost index (either the minLeft or maxLeft) whichever appears later - 0 + 1
8. For right side, the number of steps would be (n-1) - leftMost index (either minLeft or maxLeft) + 1
9. From both side, it would be leftMost index - 0 + 1
 + (n-1) - rightMost index + 1
10. Find the mininum amongst all these three -> leftSide, rightSide, bothSide
11. The minimum steps would be the answer.
12. Time - O(n)
13. Space - O(1)
*/