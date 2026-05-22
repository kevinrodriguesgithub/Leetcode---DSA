class Solution {
    public int search(int[] nums, int target) {

        int n = nums.length;

        int left = 0;
        int right = n-1;

        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] == target){
                return mid;
            }

            if(nums[left] <= nums[mid]){    // left half is sorted
                if(nums[left] <= target && target <= nums[mid]){     // target is in left half
                    right = mid - 1;;
                }
                else{
                    left = mid + 1;    // target is in right half
                }
            }
            else{
                if(nums[mid] <= target && target <= nums[right]){
                    left = mid + 1;
                }
                else{
                    right = mid - 1;
                }
            }
        }
        return -1;
   }
}

/* Explanation
1. When the sorted array is rotated, at a particular index, we can say we will have 2 sorted arrays, one at the left of this index and one to the right.
2. Initilize two pointer, left = 0, right = n -1; and continue while loop until left <= right
3. Find the mid, if(nums[mid] == target), we found the target, return the index (mid) as answer
4. Now, we check if nums[left] <= nums[mid], if it is, it means left half of the array is sorted, now check if target is between nums[left] and nums[mid]
If it is, it means we need to continue our search in left sorted array, so update right to mid - 1;
But if target is not between nums[left] and nums[mid], it means it is in right sorted array, so update left = mid + 1;
5. If the above condition itself was not true, and nums[left] <= nums[mid] is not True, it means left half is not sorted, and it means right half is sorted
We go inside the condition and we check if target is between nums[mid] and nums[right], If it is, it means target is in right half, and if not, then it is in left half
6. We continue this process until left <= right, and if we aren't able to meet the condition nums[mid] == target inside the while loop, it means the number
is not present and outside the while loop we will return -1;
*/