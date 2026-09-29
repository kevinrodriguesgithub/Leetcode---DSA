class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        
        StringBuilder sb = new StringBuilder();
        int n = s.length();

        Map<String, String> map = new HashMap<>();
        for(List<String> list: knowledge){
            String key = list.get(0);
            String value = list.get(1);
            map.put(key, value);
        }       // {name, bob}; {age, two}

        int start = -1;
        int end = -1;
        for(int i=0;i<n;i++){
            if(s.charAt(i) == '('){
                start = i;                // 0
                while(s.charAt(i) != ')'){
                    i++;
                }
                end = i;              // 5
                String replaceKey = s.substring(start+1, end);  // "name"
                String put = map.getOrDefault(replaceKey, "?" );
                sb.append(put);
            }
            else{
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}

/* Explanation
1. We need to find the words in between the parentheses ( ) and replace that word with it's associated value present in knowledge
2. It's better to store the knowledge in a hashmap key-value pair, so that it's easier to look up and extract the value
3. Store knowledge List<String> in HashMap
4. Use a for loop to iterate over String s, use StringBuilder sb to store the result
5. Whenever you encounter "(", store it's start index, and continue to move index i forward until you find ")", you are guaranteed to find ")" as per the constraint we have a valid parentheses in the input
6. Now, extract the substring based on the start and end value of "(" and ")" respectively
7. We want the replaceKey to be the actual word only and not include "(" and ")" when we look up, hence while extracting we do (start+1, end)
8. Using the hashamp, in which we have stored List<String> from knowledge, extract the associate replacement value, if it's not present we replace it with "?"
9. Append the replacement value to StringBuilder sb
10. If the character is not an "(", then we simply append that character to the StringBuilder sb
11. Thus, our final result will be in StringBuilder sb, convert it to String and return it as the answer
12. Time - O(n+k), where n is length of s and k is length of knowledge (key-value pairs)
13. Space - O(n+k)
*/