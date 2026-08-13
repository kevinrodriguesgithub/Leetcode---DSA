class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        
    // Binary search
        int n = nums.length;
        int low = 0, high = n-1;
        int start = -1, end = -1;

    // let's find start first
        while(low <= high){
            int mid = low + (high-low)/2;

            if(nums[mid] == target){
                start = mid;        // potential answer, but move in left half to check if there's prev instance 
                high = mid -1;
            }
            else if(nums[mid] > target){
                high = mid -1;
            }
            else{   // nums[mid] < target
                low = mid + 1;
            }
        }

        low = 0;
        high = n-1;
    // calculate for end
        while(low <= high){
            int mid = low + (high-low)/2;

            if(nums[mid] == target){
                end = mid;  // potential answer, but check further in right half
                low = mid +1;
            }
            else if(nums[mid] > target){
                high = mid -1;
            }
            else{   // nums[mid] < target
                low = mid + 1;
            }
        }
        return new int[]{start, end};

        // O(n)
    /*    int ans [] = new int[2];
        boolean foundFirst = false, foundLast = false;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == target){
                ans[0] = i;
                foundFirst = true;
                break;
            }
        }
        if(!foundFirst)
            ans[0] = -1;

        for(int i=nums.length-1;i>=0;i--){
            if(nums[i] == target){
                ans[1] = i;
                foundLast = true;
                break;
            }
        }
        if(!foundLast)
            ans[1] = -1;
        return ans;         */

        // O(log n)
    /*    int ans[] =  {-1,-1};
        int low = 0;
        int high = nums.length -1;
                // 5,7,7,8,8,10     // target = 8
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid] < target){
                low = mid +1;
            }
            else{
                high = mid -1;
                if(nums[mid] == target)
                    ans[0] = mid;
            }
        }
        //2nd binary search
        low = 0;
        high = nums.length -1;

        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid] > target)
                high = mid -1;
            else{
                low = mid + 1;
                if(nums[mid] == target)
                    ans[1] = mid;
            }
        }
        return ans;     */
    }
}

/* Explanation
1. One naive way to do it is, assign start and end as -1
2. Iterate the array from left and on first occurence of the target, assign index value to start
3. Similarly iterate again from the right, and on first occurence of the target, assign that index value to end.
4. But, this would be O(n)
5. As the array is sorted, we can leverage binary search
6. assign low = 0, high = n -1
7. Calculate separately for start and end
8. For start index, while low <= high, calculate mid, if nums[mid] == target, store mid in start as it's the potential answer, but start further search in left half if any previous occurence of target
 If nums[mid] > target, it means we need to search in left half
 else if nums[mid] < target, it means we need to search in right half
9. For end index, Reset low = 0, high = n-1,  while low <= high, if nums[mid] == target, store mid in end as the potential answer, and move search in further right half
  if nums[mid] > target, move to the left half
  else if nums[mid] < target, move to the right half
10. At the end, we will have the indexes for start and end, if the target does not exist, the start and end values will not be changed and will be -1
11. Time - O(log n)
12. Space - (1)
*/