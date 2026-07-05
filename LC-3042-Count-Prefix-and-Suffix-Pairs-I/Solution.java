class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        
        int n = words.length;
        int count = 0;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                boolean doesSatisfy = isPrefixAndSuffix(words[i], words[j]);
                if(doesSatisfy){
                    count++;
                }
            }
        }
        return count;
    }

    public boolean isPrefixAndSuffix(String str1, String str2){
        return isPrefix(str1, str2) && isSuffix(str1, str2);
    }

    public boolean isPrefix(String str1, String str2){
        int n1 = str1.length();
        int n2 = str2.length();

        int p1 = 0, p2 = 0;
        while(p1 < n1 && p2 < n2){
            if(str1.charAt(p1) != str2.charAt(p2)){
                return false;
            }
            p1++;
            p2++;
        }
        if(p1 == n1){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean isSuffix(String str1, String str2){
        int n1 = str1.length();
        int n2 = str2.length();

        int p1 = n1 -1, p2 = n2 -1;

        while(p1 >= 0 && p2 >= 0){
            if(str1.charAt(p1) != str2.charAt(p2)){
                return false;
            }
            p1--;
            p2--;
        }
        if(p1 == -1){
            return true;
        }
        else{
            return false;
        }
    }
}

/* Explanation
1. Iterate over all the pairs from words[] array
2. We use 2 for loops, and pass words[i], words[j] to our function - isPrefixAndSuffix()
3. Inside this function, we call isPrefix and isSuffix functions which are declared separately to check prefix and suffix
4. For prefix check, we start from left of the word and we keep on checking the char from str1 and str2, if any char at respective positions is not same, then return false immediately
5. Once we run out of pointer, we check if we have reached the end of str1, it means it is a prefix. We need to do this, bcz sometimes str1 can be > str2 in length, so while loop can terminate in that condition, but we need to ensure str1 is completely traversed.
6. Similarly, we do it for Suffix, but for suffix we keep on checking from the right
7. Time - O(n^2) for iterating over pairs, and for each pair when we check prefix and suffix, we iterate over min(str1, str2) - O(m) for that
So overall, time - O(n^2 . m), where m is maximum length of a word
8. Space - O(1)
*/