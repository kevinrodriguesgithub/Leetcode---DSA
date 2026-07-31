class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

    // O(n)   
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        for(int i=0;i<n;i++){
            int num = nums[i];
            if(map.containsKey(num)){
                int diff = Math.abs(i - map.get(num));
                if(diff <= k){
                    return true;
                }
            }
            map.put(num, i);
        }
        return false;

    // Brute force
    /*    int n = nums.length;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(nums[i] == nums[j] && Math.abs(i-j) <= k){
                    return true;
                }
            }
        }
        return false;       */
    }
}


/* Explanation
 1. Initialize HashMap
 2. Iterate over nums array, and if the current num is present in the map, check for it's prev index and current index absolute difference, if it's <= k, return True
 3. If the diff is not  <= k or if the number is not present, we will store the number along with it's current index in the map
 4. Notice, that irrespective of whether it was previously present or not, we still update the map with current index, bcz if we don't the difference between current i and previosuly stored index of that number will keep on increasing and we want to check if the difference is <= k
 5. Time - O(n); Space - O(n)   */