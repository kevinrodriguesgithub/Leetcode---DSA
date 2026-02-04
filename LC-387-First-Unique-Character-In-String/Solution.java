class Solution {
    public int firstUniqChar(String s) {
     
     // Using Map - Time O(n), Space - O(n)
    /*    Map<Character, Integer> map = new HashMap<>();

        for(int i=0;i<s.length();i++){
            Character key = s.charAt(i);
            map.put(key, map.getOrDefault(key, 0) +1);
        }

        for(int i=0;i<s.length();i++){
            if(map.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;  */

    // Method 2 -  Using array[26], Time - O(n), Space - O(1)
        int n = s.length();
        int freq[] = new int[26];

        for(char c: s.toCharArray()){
            freq[c - 'a']++;
        }

        for(int i=0;i<n;i++){
            if(freq[s.charAt(i) - 'a'] == 1){
                return i;
            }
        }
        return -1;
    }
}
/*
Method 1: Using Map
1. Create a Hashmap and count the frequency of each character in the string s and store it in the hashmap
2. Iterate over the string s again, and check each character as they appear for it's frequency in the map, if the frequency equals 1, it means that character appears just once.
3. We iterate String s in order, so whichever character's frequency equals 1, that's the earliest occurence

Method 2: Using array of size 26
1. We follow the same approach, but this time we store each character's frequency in array of size 26 (as there are 26 lowercase characters)
2. Iterate over String s again, and check if that character's frequency is 1, if it is, return that character's index
3. If no character's frequency is 1, return -1 at the end
*/