class Solution {
    public int[] arrayRankTransform(int[] arr) {
        
        int n = arr.length;

        int temp [] = Arrays.copyOf(arr, n);
        Arrays.sort(temp);      //  [10,20,30,40]

        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<n;i++){
            int num = temp[i];
            if(!map.containsKey(num)){
                map.put(num, map.size() + 1);
            }
        }       // {10,1}; {20,2} {30,3} {40,4}

        for(int i=0;i<n;i++){
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }
}

/* Explanation
1. Copy the array values into another temp[] array
2. Sort this temp[] array
3. Now, declare a hashmap, this hashmap will store the number as key and it's rank as the value, the rank would be size of map till that point +1
For eg: when we enocunter 10, we store in map as {10, 1}
Now when 20 arrives, we store {20, 2} So, the rank is size of map till that point +1, bcz size of the map is the number of unique elements till that point
4. Now our hashmap contains the elements along with it's rank
5. Now, iterate over the original arr and for each elements, get it rank from the map and store it in arr[i]
6. Return arr[]
7. Time - O(nlogn) - Due to sorting
8. Space - O(n) - Extra array used
*/