class Solution {
    public int numberOfSpecialChars(String word) {

    // Approach 2 - Better than approach 1
        int n = word.length();

        Map<Character, Integer> lowerMap = new HashMap<>();
        Map<Character, Integer> upperMap = new HashMap<>();

        for(int i=0;i<n;i++){
            char ch = word.charAt(i);
            if(ch >= 97 && ch <= 122){
                lowerMap.put(ch, i);
            }
            else if(ch >= 65 && ch <= 90){
                if(!upperMap.containsKey(ch)){
                    upperMap.put(ch, i);
                }
            }
        }

        int specialCount = 0;
        for(char key: lowerMap.keySet()){
            char  upperKey = Character.toUpperCase(key);
            if(upperMap.containsKey(upperKey) && lowerMap.get(key) < upperMap.get(upperKey)){
                specialCount++;
            }
        }
        return specialCount;

    // Approach 1
    /*    int n = word.length();

        int lower[] = new int[26];
        int upper[] = new int[26];

        for(char c: word.toCharArray()){
            if(c >= 97 && c <= 122){        // lowercase
                lower[c - 'a']++;
            }
            else if(c >= 65 && c <= 90){
                upper[c - 'A']++;
            }
        }

        Set<Character> candidates = new HashSet<>();
        for(int i=0;i<26;i++){
            if(lower[i] > 0 && upper[i] > 0){
                candidates.add((char)(i + 'A'));
            }
        }       // candidates = {A, B, C}

        Map<Character, Integer> lowerMap = new HashMap<>();
        Map<Character, Integer> upperMap = new HashMap<>();

        for(int i=0;i<n;i++){
            char ch = word.charAt(i);
            char upperChar = Character.toUpperCase(ch);
            if(candidates.contains(upperChar)){
                if(ch >= 97 && ch <= 122){
                    lowerMap.put(ch, i);            // {a,1; b,3; c,4}
                }
                else if(ch >= 65 && ch <= 90){
                    if(!upperMap.containsKey(ch)){
                        upperMap.put(ch, i);            // {A,2; B,5; C,6}
                    }
                }
            }
        }

        int specialCount = 0;
        for(char key: lowerMap.keySet()){
            char upperKey = Character.toUpperCase(key);
            if(lowerMap.get(key) < upperMap.get(upperKey)){
                specialCount++;
            }
        }
        return specialCount;        */
    }
}
// Try this example: word = "cCceDC", Expected O/P = 0

/* Explanation - Approach 1
1. Declare two arrays of size 26 and store the count of lower char in lower array and upper char in upper array
2. Iterate over these two two arrays and if the freq of both lower and upper exists for a char, then that character is a candidate for special charater, Add that character to candidates Set, make sure to convert it to Uppercase for uniformity or lowercase, your choice
3. Now, iterate over the word String, and for each char, check if it is a part of candidate Set, if it is and the current char is lower character, store it in a lowerMap with it's index.
4. If the same lower char appears again, update the index of it's latest char
5. While for upper character, we will store the index of it's earliest occurence, so once we have a Upper character in a upperMap, next time same upper char occurs, we won't do anything.
6. The reason for this is, we want all the lowercase character to appear before it's uppercase character for that char to be a special character. Hence, we will store last occurence of lower char and it's index, & 1st occurence of upper char and it's index.
7. Finally, iterate over these map and check if the last occurence of lower char is before the first occurence of upper char, if it is, that character is special. Increment the count.
8. Return the count

Approach 2:
1. Approach 1 is alright, but there's absolutely no need to find the candidates and then use lowerMap and upperMap to store it's index.
2. Instead we can simply iterate over the word, and store the latest index of lower char in lowerMap and earliest index of upper char in upperMap
3. Iterate over the lowerMap, and check if it's equivalent upper char is present in upperMap, if it is then check if index of lower char is smaller than the index of upper char, if it is increment the specialChar count
4. Return the count;
*/