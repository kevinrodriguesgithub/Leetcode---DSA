class Solution {
    public int largestInteger(int[] nums, int k) {
        
        int n = nums.length;
        int max = Integer.MIN_VALUE;

        Map<Integer, Integer> map = new HashMap<>();

        for(int i: nums){
            max = Math.max(max, i);
            map.put(i, map.getOrDefault(i, 0) +1);
        }

        int maxJustOnce = -1;
        for(int key: map.keySet()){
            if(map.get(key) == 1 && key > maxJustOnce){
                maxJustOnce = key;
            }
        }

        if(k == n){
            return max;
        }
        if(k == 1){
            return maxJustOnce;
        }

        // other case i.e. 1 < k < n
        if(map.get(nums[0]) == 1 && map.get(nums[n-1]) == 1){
            return nums[0] > nums[n-1] ? nums[0] : nums[n-1];
        }
        else if(map.get(nums[0]) > 1 && map.get(nums[n-1]) > 1){
            return -1;
        }
        else if(map.get(nums[0]) > 1){
            return nums[n-1];
        }
        else{
            return nums[0];
        }
    
    }
}

/* Explanation
1. We need to solve for three different cases, when k = 1, when k = n, and when k is > 1 and < n
2. If k = 1, it means amongst all subarrays of size 1, we simply need to find find and return the element which is largest and appears exactly once, as we need the largest which appears in only one subarray
3. If k = n, it means there will only be once subarray which is of size n, so we need simply return the largest element, even if it appears multiple times it's alright, bcz multiple occurances will be in one single subarray only, which is fine
4. If 1 < k < n, then barring the first and last element, all other elements will appear in atleast two subarrays, so the answer would be either nums[0] or nums[n-1]
5. If nums[0] and nums[n-1] both appear just once, then the largest amongst them is the answer
6. If either of them appears more than once, and other appears just once, then the one appearing just once is the answer.
7. If both of them appear more than once, then return -1
8. Time - O(n)
9. Space - O(n)
*/