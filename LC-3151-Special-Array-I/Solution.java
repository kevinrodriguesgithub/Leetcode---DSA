class Solution {
    public boolean isArraySpecial(int[] nums) {
        
    // It means every consecutive numbers must be odd-even-odd-even-odd or even-odd-even-odd...
        
        int n = nums.length;

        boolean start = (nums[0] % 2 == 0) ? true : false;
            // true - even; false - odd
        
        for(int i=1;i<n;i++){
            if(start && nums[i] % 2 == 0){      // prev even and current even
                return false;
            }
            else if(!start && nums[i] % 2 != 0){ // prev odd and current odd
                return false;
            }
            else{
                start = !start;     // toggle even-odd
            }
        }
        return true;

    }
}
/* Explanation
1. The numbers need to be in the pattern: even-odd-even-odd-even....or odd-even-odd-even-odd....
2. Check first number whether it's even or odd and assign value to the boolean start variable
3. start = true denotes even number, start = false denotes odd number
4. In for loop, start checking from second number, if previous number was even and current is also even, return false
If previous number was odd and current is also odd, return false
5. If both the false conditions are not met, toggle the start value, it means till the current point the sequence is maintained
6. At the end of the loop, if we don't encounter the false conditions, it means all the elements are in the necessary order and it's a Special Array, Return true
7. Time - O(n)
8. Space - O(1)
*/