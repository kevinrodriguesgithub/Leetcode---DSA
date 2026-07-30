class Solution:
    def maxAscendingSum(self, nums: List[int]) -> int:
        n = len(nums)
        sum = nums[0]
        maxSum = sum

        for i in range(1,n):
            if nums[i] > nums[i-1]:
                sum += nums[i]
                maxSum = max(maxSum, sum)
            else:
                sum = nums[i]
        
        return maxSum
        
#  Explanation
# 1. Initialize sum to nums[0] i.e. first number of the array
# 2. Assign maxSum = sum. Note that the numbers are positive itself
# 3. Iterate for the nums array, start from index 1, and at every index check if the number is strictly greater than it's previous number. If it is, then add it to the sum, and update the maxSum as max(maxSum, sum)
# 4. If the current number is not strictly greater than it's previous number, then we will start couting our new subarray from this index number, so assign sum = nums[i] ie current number and continue iterating
# 5. At the end, we will have our final answer updated in maxSum
# 6. Time - O(n); Space - O(1)
# 