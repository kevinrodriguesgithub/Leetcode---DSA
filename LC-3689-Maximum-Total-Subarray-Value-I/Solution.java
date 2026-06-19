class Solution {
    public long maxTotalValue(int[] nums, int k) {
        
        int n = nums.length;

        Long min = Long.MAX_VALUE;
        Long max = Long.MIN_VALUE;
        for(int i: nums){
            if(i < min){
                min = (long) i;
            }
            if(i > max){
                max = (long) i;
            }
        }

        Long diff = max - min;
        return diff * k;
    }
}

/* Explanation
1. As the same subarray can be chosen more than once, so all we need is the max in the subarray and min in the subarray, so that the difference is maximum
2. We can simply consider the whole array as the subarray and once we know the min and the max, find it's difference and consider the same subarray k times, so multiple the difference we found by k and that's the answer
3. Time - O(n); Space - O(1)

*/