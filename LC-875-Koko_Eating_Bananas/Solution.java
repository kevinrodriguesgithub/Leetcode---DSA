class Solution {
    public int minEatingSpeed(int[] piles, int h) {

    // Binary search
        int n = piles.length;
        int maxEle = Integer.MIN_VALUE;
        for(int p: piles){
            maxEle = Math.max(maxEle, p);
        }

        int low = 1;        // min k as koko can eat 1 /hr assume
        int high = maxEle;  //max k assuming koko can eat max banana/hr
        int ans = Integer.MAX_VALUE;
        while(low <= high){
            int mid = low + (high - low)/2;
            int timeTaken = calcHours(piles, mid);
            if(timeTaken <= h){             // possible answer, but also check if we can reduce reduce eating speed (k) as we need the minimum
                ans = Math.min(ans, mid);
                high = mid - 1;
            }
            else{       // timeTaken > h, taking more time, so need to increase eating speed (k), move right
                low = mid + 1;
            }
        }
        return ans;

    // Time limit error - O(n) * O(maxEle)
    /*    int n = piles.length;
        int maxEle = Integer.MIN_VALUE;
        for(int p: piles){
            maxEle = Math.max(maxEle, p);
        }

        for(int i=1;i<=maxEle;i++){
            int timeTaken = calcHours(piles, i);
            if(timeTaken <= h){
                return i;
            }
        }
        return -1;  */
    }

    public int calcHours(int[] piles, int eatSpeed){

        int hours = 0;
        for(int p: piles){
            hours += Math.ceil((double) p / (double) eatSpeed);
        }
        return hours;
    }
}

/* Explanation
1. We need to have minimum value of k (which is eatingSpeed)
2. We can start checking from k = 1 and go upto the maximum value in the piles[] array
3. For every value of k, calculate the hours it would take to eat all the bananas in the pile
4. For brute force, we can have a loop from 1 to maxElement in piles (As that's the highest value of k that makes sense - considering maxEle as 11, so having max eating speed as 11 makes sense, having 12, 13...or anything above will still yield same time)
5. In Brute force, once we the timeTaken (hours) as <= h, i.e within the limit, we can return the current value of eating speed which is the answer.
6. But brute force will yield time complexity as O(n) * O(maxEle); O(n) to calculate the timeTaken hours and we iterate from 1  to maxEle to check each eatingSpeed
7. So instead we can reduce the time complexity and not check every value from 1 to maxEle
8. We can use binary search technique
9. Assign low = 1, minimum eating speed, high = maxEle, maximum eating speed
10. Calculate mid and pass mid as the eatSpeed value; we calculate the hours taken using mid eatSpeed
11. If timeTaken was <= high, mid is the possible answer, so assign ans = Math.min(ans, mid)
But we can also go towards left and check for smaller eatSpeed value, so move high = mid - 1;
12. Else if the time taken is > h, it means eatSpeed is too slow and we need to increase speed,
so move low = mid + 1 
13. Finally when low <= high will not be true and our answer will be in ans
14. Return ans
15. Time - O(n)*O(log(maxEle))
*/
