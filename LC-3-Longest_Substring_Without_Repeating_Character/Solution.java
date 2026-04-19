class Solution {
    public int lengthOfLongestSubstring(String s) {
     
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int maxLen = 0;
        int left = 0;
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);

            while(left <= i && set.contains(ch)){
                set.remove(s.charAt(left));
                left++;
            }
            if(!set.contains(ch)) {
                set.add(ch);
                maxLen = Math.max(maxLen, (i - left + 1));
            }
        }
        return maxLen;
     
    // Similar but another way
    /*   Set<Character> set = new HashSet<>();
       int left = 0;
       int res = 0;

       for(int i=0;i<s.length();i++){
            while(set.contains(s.charAt(i))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(i));
            res = Math.max(res, i - left +1);
       } 
       return res;  */
       
   }
}

/* Explanation.
1. We will use sliding window approach
2. Start iterating the string, and use a Set to store unique characters in current substring 
3. Keep a left pointer at 0, as we will need the left pointer to calculate the current length of the substring
4. Start iterating each char, If the set doesn't contain the current char, add it to the set, calculate the current length which will be (i - left + 1)
5. Compare current len with maxLen, and update maxLen accordingly
6. In the loop, we also need to check if the set already contains the current character, if it does start removing the character from the set from the left pointer and increment left. We keep on removing until the current char at index i is not present in the Set
7. Towards the end we will have our maxLen as the answer
*/