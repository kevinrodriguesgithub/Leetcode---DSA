class Solution {
    public int maxVowels(String s, int k) {

        int n = s.length();
        Set<Character> vowelSet = Set.of('a', 'e', 'i', 'o', 'u');
        
        int count = 0;
        for(int i=0;i<k;i++){   // initial window
            char ch = s.charAt(i);
            if(vowelSet.contains(ch)){
                count++;
            }
        }   // lee => count = 2
        
        int left = 0;
        int maxCount = count;
        for(int i=k;i<n;i++){
            char ch = s.charAt(i);
            if(vowelSet.contains(ch)){
                count++;
            }
            if(vowelSet.contains(s.charAt(left))){
                count--;
            }
            if(count == k)      // Helps in early exit
                return count;
            left++;
            maxCount = Math.max(maxCount, count);   // If we just return count, it will give count of last substring of size K
        }
        return maxCount;   
    }
}

/* Explanation:
1. We store the lower character vowels in a Set
2. We will go ahead with slidign window approach. 
3. For initial window of size K, check each character one by one if it's a vowel, if it is, increment the count.
4. Assign vowelCount in initialWindow to maxCount
5. Now shrink window from left and expand from right, but check if the char at the right while expanding is a vowel, if it is increment count
6. At the same time, while shrinking from left, check if left char was a vowel, if it was decrement it's count
7. Once you check left and right characters, update the maxCount if the count > than it
8. At the end, you will have explroed all the windows and answer would be in maxCount
9. Another edge case/early exit case would be if the maxCount gets equal to K, then stop and return the answer as that's the highest count you can achieve in any window.

*/