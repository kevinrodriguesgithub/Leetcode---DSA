class Solution {
    public int minOperations(int[] nums, int x) {
        
        int n = nums.length;
        int total = 0;

        for(int num: nums){
            total += num;
        }
        int target = total - x;

        int left = 0;
        int windowSum = 0;
        int maxLen = -1;

        for(int right = 0; right<n; right++){
            windowSum += nums[right];
            while(left <= right && windowSum > target){
                windowSum -= nums[left];
                left++;
            }
            if(windowSum == target){
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }
        if(maxLen == -1){
            return -1;
        }

        return n - maxLen;
    }
}
/* We can solve it by using maximum subarray sum concept.
1. Find the total sum of the array, store it in total
2. Find the target, which is total - x, now we will try to find the maximum subarray whose sum is equal to this target, and this target is (total - x), so now remaining elements sum would be equal to x, and we took the maximum subarray sum equal to target, so now remaining elements which are equal to x will be minimum
3. Now find the maximum subarray sum equal to target 
4. Use left and right pointer and windowSum
5. Store the sum in windowSum and if windowSum becomes equal to target, calculate the length, and update the maxLen
6. If the windowSum becomes > target, we need to shrink the window, subtract nums[left] and move left pointer forward
7. If the maxLen is still -1, it means we never found a windowSum equal to target (As in example 2), so simply return -1 in that case
8. Otherwise our answer would be (n - maxLen) where n is total length of the array and maxLen is maximum length of subarray sum equal to target
9. Time - O(n)
10. Space - O(n)
*/