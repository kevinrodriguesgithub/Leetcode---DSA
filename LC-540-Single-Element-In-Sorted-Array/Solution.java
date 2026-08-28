class Solution {
    public int singleNonDuplicate(int[] nums) {
        
        // O(log n) - check striver for code and explanation
        int n = nums.length;
        if(n==1)
            return nums[0];

        if(nums[0] != nums[1])
            return nums[0];
        if(nums[n-1] != nums[n-2])
            return nums[n-1];

        int low = 0, high = n-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid] != nums[mid+1] && nums[mid] != nums[mid-1])
                return nums[mid];
            //left half    
            if((mid%2 == 1 && nums[mid] == nums[mid-1]) || 
                (mid%2 == 0 && nums[mid] == nums[mid+1]))
                    low = mid +1;
            else
                    high = mid -1;
        }
        return -1;      

        // O(n)
    /*    int n = nums.length;
        if(n==1)
            return nums[0];

        if(nums[0] != nums[1])
            return nums[0];
        if(nums[n-1] != nums[n-2])
            return nums[n-1];

        for(int i=1;i<n-1;i++){
            if((nums[i] != nums[i-1]) && (nums[i] != nums[i+1]))
                return nums[i];
        }
        return -1;  */

        // Using XOR - O(n)
    /*    int res = 0;
        for(int i:nums){
            res = res ^ i;
        }
        return res; */
    }
}

/* Explanation
1. We can solve this using multiple ways. One way is use a set and if it already contains the num, remove it. If not present add it. At the end only 1 element which occured once will be present in the set. Time - O(n)
2. Another way is using XOR - as any num XOR with itself is 0 and number XORed with 0 is that num
3. We will use binary search technique to solve it in O(n)
4. As only 1 number occurs once, that number if we compare to it's left neighbour and right neighbour and it's not equal to both of them, it means that number itself is unique and is our answer
5. Edge cases: If n==1, return that number; Compare 1st and 2nd numbers, if they are unequal, return 1st number as it's unique
Compare last and second last numbers, if they are unequal, return last number as it is unique
6. If the answer is not found in the above edge cases, it means the unique number lies somewhere in the middle
7. start with low = 0, high = n-1
8. Calculate mid, and check if nums[mid] is not equal to it's left nums[mid-1] and nums[mid] is not equal to it's right, nums[mid+1], if it's unequal on both of it's neighbours, nums[mid] is the answer
9. Now, another observation we can make here is, as the elements are sorted and are in a pair, element at index 0 and index 1 will be same, index 2-3 will be same and so on...
10. So, if our mid is at even index, the element on it's right would be the same
and if our mid is at odd index, the element on it's left would be the same
11. If either of this property satisfies, it means the pattern is not broken yet, hence the unique element which breaks this pattern should be on the right side of mid, so update low = mid +1
12. Else, if the pattern is broken, this number is on the left half, update high = mid - 1
13. We continue this until low <= high, and eventually we will find a mid, where nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1] would be true, and we will get our answer.
14. Time - O(n) 
*/