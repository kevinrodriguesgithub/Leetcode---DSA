class Solution {
    public int longestBalanced(String s) {

    // Brute force - O(n^2 * m)
        int n = s.length();
        int longest = 0;

        for(int i=0;i<n;i++){
            Map<Character, Integer> map = new HashMap<>();
            for(int j=i;j<n;j++){
                boolean flag = false;
                char ch = s.charAt(j);
                map.put(ch, map.getOrDefault(ch, 0) +1);
                int curr = map.get(ch);
                for(int val: map.values()){     // Iterate over map's frequencies
                    if(val == curr){
                        flag = true;
                        continue;
                    }
                    else{
                        flag = false;
                        break;
                    }
                }
                if(flag){       // Update longest as all frequencies are same
                    longest = Math.max(longest, j-i +1);
                }
            }
        }
        return longest;
    }
}

/* Explanation:
1. Iterate over every substring
2. While iterating over each char, update the frequency of that character in a map
3. For each substring, check for all the frequencies stored in the map
4. Store current char's frequency in int char and then check if the frequency of all the char's in the map  is equal to it
5. If at any point, the frequency is not equal, set flag to false and break out
6. The if(flag) condition after the for loop, will be executed only if all the frequencies in the map are equal, in that case we will try to update longest
7. Similarly, after each substring is explored, finally we will return the answer stored in longest
*/