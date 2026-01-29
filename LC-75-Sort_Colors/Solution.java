class Solution {
    public void sortColors(int[] nums) {

        int n = nums.length;
        int left = 0;
        int right = n-1;

        int i=0;
        while(i<=right){
            if(nums[i] == 0){
                int temp = nums[i];
                nums[i] = nums[left];
                nums[left] = temp;
                left++;
            }
            else if(nums[i] == 2){
                int temp = nums[i];
                nums[i] = nums[right];
                nums[right] = temp;
                right--;
                i--;    // bcz swapped ele can be 0, and needs to be checked, as we increment i
            }
            i++;
        }
    }
}

/*
Explanation:
1. Use left and right pointers and initialize them to the left and right extremes respectively.
2. Start iterating from 0 index, if current number is 0, swap it with left as 0 needs to be at extreme left, increment left
3. If current number is 2, swap it with right as 2 needs to be at extreme right, decrement right
4. When 2 is swapped, at the same time decrement i, as the number which just got swapped needs to be checked as well and we increment i after each iteration, hence we need to decrement i.
5. When i exceeds right, stop the loop, because if i goes past right, the right positions are already swapped and are at their correct position
*/