class Solution {
    public int countCharacters(String[] words, String chars) {

    // Using freq array
        int charFreq[] = new int[26];
        for(char c: chars.toCharArray()){
            charFreq[c - 'a']++;
        }

        int res = 0;
        for(String str: words){
            int freq[] = new int[26];
            for(char ch: str.toCharArray()){
                freq[ch - 'a']++;
            }

            boolean flag = true;
            for(int i=0;i<26;i++){
                if(freq[i] > charFreq[i]){
                    flag = false;
                    break;
                }
            }
            if(flag){
                res += str.length();
            }
        }
        return res;

    // Using map
    /*    char chArr[] = chars.toCharArray();
        Map<Character, Integer> charMap = new HashMap<>();
        
        for(char c: chArr)
            charMap.put(c, charMap.getOrDefault(c, 0) +1);
        
        int count = 0;
        for(int i=0;i<words.length;i++){
            char eachWord[] = words[i].toCharArray();
            Map<Character, Integer> wordMap = new HashMap<>();

            for(char c: eachWord)
                wordMap.put(c, wordMap.getOrDefault(c, 0) +1);
            
            boolean flag = true;
            for(char key: wordMap.keySet()){
                if(!charMap.containsKey(key) || charMap.get(key) < wordMap.get(key)){
                    flag = false;
                    break;  // comes out of keySet for loop
                }
            }
            if(flag){
                count += words[i].length();
            }
        }
        return count;       */
    }
}

/* Explanation
1. In a freqCount array of size 26, count the characters of String chars
2. Use for each loop to iterate over words[] array
3. For each String in word, count it's characters in a freq[] array of size 26
4. Assign a boolean flag = true;
5. Now check if count of any character in any word(String) in words[] array is > count of that corresponding character in chars, it means we cannot form the word, assign flag = false, break out and proceed to the next word
6. If the above condition doesn't break, and it means every character in word is <= count of every character in chars, so this word can be formed, so include it's length in the result
7. Finally return the result which stores the length of all the words which can be formed (good strings)
8. Time - O(M) for iterating through chars, where M is length of chars; 
O(N) where is the total number of characters of all the words in the words[]
So time = O(M + N)
9. Space - O(1)
*/