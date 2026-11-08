class Solution {
    public String sortString(String s) {
        
        int freq[] = new int[26];
        int size = s.length();

        for(char ch: s.toCharArray()){
            freq[ch - 'a']++;
        }

        StringBuilder sb = new StringBuilder();

        while(size > 0){
            for(int i=0;i<26;i++){
                if(freq[i] > 0){
                    sb.append((char)(i + 'a'));
                    freq[i]--;
                    size--;
                }
            }

            for(int i=25;i>=0;i--){
                if(freq[i] > 0){
                    sb.append((char)(i + 'a'));
                    freq[i]--;
                    size--;
                }
            }
        }
        return sb.toString();
    }
}

/* Explanation
1. Count the frequency of each character and store in a freq[] array
2. Store the length of Input String s, in a size variable
3. Start iterating from left side in a for loop, and if the current frequency of character is > 0, then append that char to the result, now proceed to the next char..., keep appending the next char as we need the smallest char which is greater than the previous char... until we reach the end of each char.
4. Now take another for loop, which will start checking from right ie character 'z', check if the char exists and if it does, append that char to the result and keep moving left as we need to append the next largest character which is smaller than the previous one
5. Every time we append a character to the result, reduce the size by one, as we have appended a character.
6. We will run the two for loops mentioned until the size is > 0, it means until we process all the characters
7. Finally, we will have answer stored in the result. Convert the result to String and return it
8. Time - O(n)
9. Space - O(n)
*/