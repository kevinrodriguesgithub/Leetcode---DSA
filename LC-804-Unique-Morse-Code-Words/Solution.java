class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        
        HashMap<Character, String> mp = new HashMap<>();
        mp.put('a', ".-");
        mp.put('b', "-...");
        mp.put('c', "-.-.");
        mp.put('d', "-..");
        mp.put('e', ".");
        mp.put('f', "..-.");
        mp.put('g', "--.");
        mp.put('h', "....");
        mp.put('i', "..");
        mp.put('j', ".---");
        mp.put('k', "-.-");
        mp.put('l', ".-..");
        mp.put('m', "--");
        mp.put('n', "-.");
        mp.put('o', "---");
        mp.put('p', ".--.");
        mp.put('q', "--.-");
        mp.put('r', ".-.");
        mp.put('s', "...");
        mp.put('t', "-");
        mp.put('u', "..-");
        mp.put('v', "...-");
        mp.put('w', ".--");
        mp.put('x', "-..-");
        mp.put('y', "-.--");
        mp.put('z', "--..");

        Set<String> set = new HashSet<>();
        for(String str: words){
            StringBuilder sb = new StringBuilder();
            for(char ch: str.toCharArray()){
                sb.append(mp.get(ch));
            }
            set.add(sb.toString());
        }
        return set.size();
    }
}

/* Explanation
1. Declare a hashmap to store the morse code for all the respective 26 letters
2. Iterate over the words[] array
3. For each String, iterate over the string and append each character's morse code to a String builder, after iterating over each word, convert the string builder to a string and add that value to a set
4. For any String, where appending the morse code, yields in the same result string, duplicate wont be added as we are storing it in a Set
5. Finally, the size of the set will be the number of unique values we will have
6. Time - O(n.k) - where n is length of words[] and k is avg length of each string in words[]
7. Space - O(1) - 26 unique morse codes for 26 characters
*/