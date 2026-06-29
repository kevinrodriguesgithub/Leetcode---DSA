class Solution {
    public int maxIceCream(int[] costs, int coins) {
        
    // Using sorting - O(nlogn)
        Arrays.sort(costs);
        int sum = 0;
        int count = 0;

        for(int i=0;i<costs.length;i++){
            sum += costs[i];
            if(sum > coins){
                break;
            }
            count++;
        }
        return count;
    }
}

/* Explanation
1. Sort the costs array as we need to buy the least expensive first
2. From the sorted array, start counting the prices in a sum variable, until the sum crosses over the coins you have
3. For every item that you add in sum, increment count as that's the item we are buying
4. When the sum reaches > coins, it means u cannot afford current item, break immediately
5. Return the count
6. Time - O(nlogn) - Due to sorting
7. Space - O(1) - No extra space
*/