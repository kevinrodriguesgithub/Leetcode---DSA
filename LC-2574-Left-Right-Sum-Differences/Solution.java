class Solution {
    public int[] leftRightDifference(int[] nums) {
        
        int n = nums.length;

        int leftArr[] = new int[n];
        int rightArr[] = new int[n];

        int sum = 0;
        for(int i=1;i<n;i++){
            sum += nums[i-1];
            leftArr[i] = sum;
        }

        sum = 0;
        for(int i=n-2;i>=0;i--){
            sum += nums[i+1];
            rightArr[i] = sum;
        }

        for(int i=0;i<n;i++){
            nums[i] = Math.abs(leftArr[i] - rightArr[i]);
        }
        return nums;
    }
}

/* Explanation:
1. Declare a leftArr and rightArr of size n
2. For calculating and filling the values in leftArr, start from i=1 to i<n; because at i=0, there won't be any elements on it's left. So that position will have sum = 0;
3. Keep adding the previous element to the sum and assign the sum value to leftArr[i]
4. Similarly, perform the iteration and sum from the end for the rightArr
5. Now, we can use the input nums array to store the result as nums is no longer reqd
6. Calculate Math.abs(leftArr[i] - rightArr[i])
7. Our final difference is stored in nums array, return it.
*/