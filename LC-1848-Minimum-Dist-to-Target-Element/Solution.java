class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        
        int n = nums.length;
        int ans = Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            if(nums[i] == target){
                int diff = Math.abs(i - start);
                if(diff < ans){
                    ans = diff;
                }
            }
        }
        return ans;
    }
}

/* Explanation:
1. We initialize the answer as Integer MAX_Value, 
2. Now, we iterate through the loop and whenever, we find an element in nums array equal to target, we find the absolute different of (i - start)
3. If this difference is less than current ans, then update the ans to this difference
4. At the end of the loop, we will have the answer
5. As it is guaranteed that target exists in nums, so we don't have to worry that we have set initial value of ans as Integer MAX_VALUE, as it will get adjusted
*/