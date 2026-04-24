class Solution {
    public void duplicateZeros(int[] arr) {
        
    // 1. Space optimized
        int n = arr.length;
        int zeroCount = 0;

        for(int a: arr){
            if(a == 0){
                zeroCount++;
            }
        }

        int i = n-1;
        int j = n-1 + zeroCount;

        while(i >= 0){      // start iterating fromm right corner
            if(j < n){
                arr[j] = arr[i];
            }

            if(arr[i] == 0){
                j--;
                if(j < n) {
                    arr[j] = 0;     // additional 0
                }
            }
            i--;
            j--;
        }           
    
    // Using extra array but in a slightly differen way and while loop
    /*    int n = arr.length;
        int ans [] = new int[n];

        int idx = 0;
        int i = 0;
        while(idx < n){
            ans[idx] = arr[i]; 
            idx++;   
            if(idx < n && arr[i] == 0){        // if 0, we need to enter additional 0 
                ans[idx++] = 0;
            }
            i++;
        }

        for(int k=0;k<n;k++){
            arr[k] = ans[k];
        }       */

     // Using extra array
    /*    int n = arr.length;
        int ans [] = new int[n];

        int idx = 0;
        for(int i=0;i<n;i++){
            if(arr[i] != 0){
                ans[idx++] = arr[i];
            }
            else{   // arr[i] is 0
                ans[idx++] = 0;
                ans[idx++] = 0;
            }
            if(idx >= n){
                break;
            }
        }

        for(int i=0;i<n;i++){
            arr[i] = ans[i];
        }       */


    // fails - not the correct logic
    /*    int n = arr.length;
        int left = 0, right = n-1;
        int zeroCount = 0;

        while(left < right){
            if(arr[left] == 0){
                zeroCount++;
                right--;
            }
            left++;
        }

        right = n-1;

        while(right >= 0){
            if(arr[right - zeroCount] != 0){
                arr[right] = arr[right - zeroCount];
                right--;
            }
            else{
                arr[right] = 0;
                right--;
                arr[right] = 0;
                right--;
                zeroCount--;
            }
        }
            */

        // Time - O(n), But we used extra space, so space also O(n)
    /*    List<Integer> list = new ArrayList<>();
        int zeroCount = 0;
        for(int i=0;i<arr.length;i++){
            list.add(arr[i]);
            if(arr[i] == 0){
                list.add(0);
                zeroCount++;
            }
        }  
        for(int i=0;i<list.size()-zeroCount;i++){
            arr[i] = list.get(i);
        }      */

    }
}

/* Explanation for space optimized soltuion:
1. First iterate over the array and count the number of zeroes
2. Now initialize i to end of array and j to end of array + num of zeroes
3. Now, we start iteratig from backward, while i >= 0,
if j < n, meaning if j is within the boundary, place arr[i] into arr[j], if the current element (arr[i]) is 0, it means after placing arr[i] into arr[j], again we need to move j pointer to left and add one more zero.
4. Be mindful of j pointer not going out of bounds, as if i = 0 and arr[i] = 0, then if we decrement j--, then it can go out of bounds
5. Towards the end of iteration we would have made the necessary changes.
*/