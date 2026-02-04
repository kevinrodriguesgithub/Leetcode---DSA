class Solution {
    public boolean isTrionic(int[] nums) {
        
        int n = nums.length;
        
        if(n < 4){
            return false;
        }

        int i = 0;
        int condition = 0;

        while(i<n-1 && nums[i+1] > nums[i]){
            condition = 1;
            i++;
        }

        if(condition == 1){ // if condition 1 satisfied, only then check 2nd condition
            while(i<n-1 && nums[i+1] < nums[i]){
                condition = 2;
                i++;
            }
        }

        if(condition == 2){
            while(i<n-1 && nums[i+1] > nums[i]){
                condition = 3;
                i++;
            }
        }

        return condition == 3 && i == n-1;
    }
}
// [1,3,5,4,6,4,2,6] => false, 
/* Explanation:
1. Since 0 < p < q < n-1, so we need atleast 4 elements to form the mountain i.e. increasing, decreasing, increasing
2. Initilize i to 0 which we will use to iterate and condition to 0.
3. First we start by 1st condition, if atleast 1 element is greater than it's previous (in order), then 1st condition is met and we set it to 1 and increment i and continue until the increasing sequence breaks
4. Then we check 2nd condition, if atleast 1 element is smaller than it's previous (in order), then 2nd condition is met and we set it to 2 and increment i and continue until the decreasing sequence breaks
5. Next, we check the 3rd condition, if atleast 1 element is greater than it's previous (in order), 3rd condition is also met.
6. But, we need to be mindful that when 3rd condition is met, the increasing sequence should be followed till the end of the array (n-1)
Hence, along with condition == 3, we also check if i == n-1
*/
