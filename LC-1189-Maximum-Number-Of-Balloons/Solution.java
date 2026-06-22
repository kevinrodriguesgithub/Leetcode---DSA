class Solution {
    public int maxNumberOfBalloons(String text) {
    
        if(text.length() < 7){      // bcz "balloon" has 7 letters
            return 0;
        }

        String word = "balloon";
        Map<Character, Integer> textMap = new HashMap<>();
        Map<Character, Integer> balloonMap = new HashMap<>();

        for(char c: text.toCharArray()){
            textMap.put(c, textMap.getOrDefault(c, 0) +1);
        }

        for(char c: word.toCharArray()){
            balloonMap.put(c, balloonMap.getOrDefault(c, 0) +1);
        }

        int ans = Integer.MAX_VALUE;
        for(char ch: balloonMap.keySet()){
            if(textMap.containsKey(ch)){
                int count = textMap.get(ch) / balloonMap.get(ch);
                ans = Math.min(ans, count);
            }
            else{
                return 0;
            }
        }
        return ans;
    }
}

/* Explanation
1. If the input text length is < 7, return 0, as balloon word itself is of 7 letters
2. Declare 2 different maps, in 1st map (textMap) store the frequencies of all characters from input text String
In 2nd map (balloonMap), store the frequencies of the word "balloon"
3. Now, start iterating over the balloonMap,
each character i.e. key from balloonMap should be present in textMap, 'b','a', 'l', 'o', 'n'
If any character is missing, immediately return 0
4. If key from balloonMap we are iterating is present in textMap, divide it's count ie. count of that key from textMap / count of that key from balloonMap
5. Assign Math.min from this count and the existing ans
We need to use Math.min, bcz let's say 'b' was present twice, but if 'a' is present once, then we can form ballon word just once not twice even if 'b' was there twice, but 'a' is only once
6. If any char from balloonMap is not present in textMap, we cannot form the word, return 0 immediately
7. Return ans at the end of iteration from ballonMap
8. Time - O(n) + O(7) => n is length of text
9. Space - O(1) => Looks like O(1), but we store only the 26 characters (letters), so max size of textMap can be 26 only
*/