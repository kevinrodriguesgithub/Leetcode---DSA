class Solution {
    public int minPairSum(int[] nums) {

    // Method 1    
    /*     Arrays.sort(nums);
        int n = nums.length;

        int ans = Integer.MIN_VALUE;
        int right = n/2;		// start from the middle and expand from it, go towards left and right in each iteration
        int left = right -1;		

        while(left >= 0 && right < n){
            int sum = nums[left] + nums[right];
            if(sum > ans){
                ans = sum;
            }
            left--;
            right++;
        }
        return ans;     */

    // Method 2 - Similar to method 1
        Arrays.sort(nums);
        int n = nums.length;

        int ans = Integer.MIN_VALUE;
        int left = 0;
        int right = n-1;

        while(left<right){
            int sum = nums[left] + nums[right];
            if(sum > ans){
                ans = sum;
            }
            left++;
            right--;
        }
        return ans;
    }       
}
// Eg: 2,3,4,4,5,6

/*
1. We want to minimize the maximum pair sum, so it means we can pair smallest with largest, 2nd smallest with 2nd largest and so on...bcz if we don't do that - let's say largest is paired with 2nd smallest, then too it will yield maximum (but we want to reduce such value)
2. So, sort the array and just pair, 1st with last, 2nd with second last and so on
3. Now, we have formed the pairs and amongst them we need the maximum pair sum
4. At each iteration calculate sum and if it's greater than ans, update the ans
5. Return ans;
*/