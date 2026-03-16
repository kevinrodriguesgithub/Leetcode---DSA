class Solution {
    public int minMoves(int[] nums) {
        
        int n = nums.length;
        int maxNum = Integer.MIN_VALUE;

        for(int i: nums){
            if(i > maxNum){
                maxNum = i;
            }
        }

        int moves = 0;
        for(int i: nums){
            if(i != maxNum){
                moves += (maxNum - i);
            }
        }
        return moves;
    }
}

/*  Explanation:
1. As we can only increment each element by 1, it means to make all elements equal, all elements needs to be equal to the maximum element of the array
2. Find the maximum element
3. Now iterate over the nums array again and if the current element is not the maxElement, then in order to make it equal to maxElement, we need (maxElement - currEle) moves for each element
4. Calculate these move values for every element and that's your answer
*/