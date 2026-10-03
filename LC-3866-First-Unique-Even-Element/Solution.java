class Solution {
    public int firstUniqueEven(int[] nums) {


    /*    int n = nums.length;
        int freq[] = new int[101];

        for(int i: nums){
            freq[i]++;
        }

        for(int i: nums){
            if(i % 2 == 0 && freq[i] == 1){
                return i;
            }
        }
        return -1;  */

    // Using Map
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i: nums){
            map.put(i, map.getOrDefault(i, 0) +1);
        }

        for(int i: nums){
            if(i%2 == 0 && map.get(i) == 1){
                return i;
            }
        }
        return -1;
    }
}

/* Explanation
1. Store the numbers for it's frequency in a hashmap or int[] freq here as the constraints are small
2. Now iterate over the nums array again and check if the current number is an even number, if it is, check if it's frequency == 1
3. If both of these conditions get satisfied, we have found the number, return it
4. After iterating over the array, if the condition is not satisfied, at the end we will return -1
5. Time - O(n)
6. Space - O(1) as there are 26 lowercase alphabets only
*/