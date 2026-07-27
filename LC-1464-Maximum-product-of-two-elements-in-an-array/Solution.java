class Solution {
    public int maxProduct(int[] nums) {

    // O(n)  
    /*    int n = nums.length;
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        for(int i=0;i<n;i++){
            if(nums[i] > max){
                max = nums[i];
                maxIndex = i;
            }
        }

        int secondMax = Integer.MIN_VALUE;
        int diff = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(i == maxIndex){
                continue;       // skip the max value's index, else second max will also be same
            }
            int d = max - nums[i];
            if(d < diff){
                diff = d;
                secondMax = nums[i];
            }
        }

        return (max-1) * (secondMax-1);     */   

    // Using Sorting - O(nlogn)
    /*    int n = nums.length;
        Arrays.sort(nums);  // 2,3,4,5

        return (nums[n-1] -1) * (nums[n-2] -1); // last 2 indexes  
    */

    // Using Heap - O(n log k), but k is 2, so O(n log 2) i.e O(n) as log 2 ~~ 1 (constant)

    /*    int n = nums.length;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int num: nums){
            minHeap.offer(num);
            if(minHeap.size() > 2){
                minHeap.poll();
            }
        }

        return (minHeap.poll() -1) * (minHeap.poll() -1);       */

    // Find max and second max

        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;

        for(int i=0;i<n;i++){
            if(nums[i] > max){
                max = nums[i];
                maxIndex = i;
            }
        }

        int secondMax = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(i == maxIndex){     // it's the maxIndex number
                continue;
            }
            if(nums[i] > secondMax){
                secondMax = nums[i];
            }
        }
        return (max - 1) * (secondMax - 1);
    }
}

/* Explanation
There are multiple ways to solve it.
1. One approach is iterate through the loop to find the maximum value, also note the index which had the maximum value (In case max values are duplicates, so both of them will contribute to max and secondMax)
2. Iterate over the loop again and if the index is of max, skip that number, and in similar way find secondMax.
3. Finally multiply (max - 1) and (secondMax - 1);

Another simple approach is using Arrays.sort()
1. Simply sort the array and pick the last two elements.
2. Subtract 1 from each of those two and multiply

Another apporach is using Heap
1. In a MinHeap, keep on adding the values from the array
2. When size becomes > 2, poll() out the top value, as it will have the minimum value at the top
3. The maximum two values will be remaining in the minHeap
4. Poll out the values, subtract -1 and multiply them
*/