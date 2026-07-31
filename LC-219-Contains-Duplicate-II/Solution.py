class Solution:
    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        counter = {}
        n = len(nums)

        for i in range(0, n):
            num = nums[i]
            if num in counter:
                if abs(i - counter[num]) <= k:
                    return True
            counter[num] = i
        return False

# Explanation
# 1. Initialize dictionary "counter"
# 2. Iterate over nums array, and if the current num is present in the dictionary, check for it's prev index and current index absolute difference, if it's <= k, return True
# 3. If the diff is not  <= k or if the number is not present, we will store the number along with it's current index in the dictionary
# 4. Notice, that irrespective of whether it was previously present or not, we still update the dictionary with current index, bcz if we don't the difference between current i and previosuly stored index of that number will keep on increasing and we want to check if the difference is <= k
# 5. Time - O(n); Space - O(n)