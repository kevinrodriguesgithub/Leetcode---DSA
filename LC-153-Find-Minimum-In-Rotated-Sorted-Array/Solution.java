class Solution {
    public int findMin(int[] nums) {

    // find out the sorted half, pick smallest from that and elimitate sorted half

        int n = nums.length;
        int low = 0, high = n-1;
        int min = Integer.MAX_VALUE;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(nums[low] <= nums[mid]){     // left half sorted
                min = Math.min(min, nums[low]);     // lowest in this half will be nums[low]
                low = mid + 1;          // eliminate the left sorted half now
            }
            else{           // right half sorted
                min = Math.min(min, nums[mid]);     // lowest in this half will be nums[mid];
                high = mid -1;   
            }
        }
        return min;


    // O(log n)
     /*   int n= nums.length;
        if(n==1)
            return nums[0];
        
        boolean rotated = true;
        if(nums[0] < nums[n-1]){
            rotated = false;
        }

        if(rotated == false){
            return nums[0];
        }
        else{
            int left = 0;
            int right = n-1;        // 3 1 2

            while(left<right){
                int mid = left + (right-left)/2;
                if(nums[mid] > nums[right]){    // it's in right half
                    left = mid +1;
                }
                else{
                    right = mid;
                }
            }
            return nums[left];
        }       */

       // O(n) 
    /*    int min = Integer.MAX_VALUE;
        for(int i: nums){
            if(i<min){
                min = i;
            }
        }
        return min; */
    }
}

/* Explanation
1. We will store our answer in min variable, which we will initialize with Integer.MAX_VALUE;
2. As the array is sorted and rotated, either left half or right half will be sorted at given point
3. After finding the mid, check if left half or right half is sorted. We will check that by if(nums[low] <= nums[mid]), then left half is sorted or right half is sorted
4. In sorted left half, the minimum would be at the extreme left, check that value with current min value and accordingly update min. Now there's no use of current left half as we have already picked the minimum from it, so update low = mid + 1, and move to the right half
5. If the right half was sorted, we would have done something opposite, pick, the extreme left from right half i.e. nums[mid] and check with the current min, and update accordingly, and now move to the left half for further iteration by updating high = mid - 1
6. Thus, at every iteration we eliminate one half and finally our answer would be stored in min
7. Time - O(log n)
8. Space - O(1)
*/