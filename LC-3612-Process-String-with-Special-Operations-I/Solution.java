class Solution {
    public String processStr(String s) {
        
        int n = s.length();
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(ch >= 97 && ch <= 122){
                sb.append(ch);
            }
            else if(ch == '*'){
                if(sb.length() > 0){
                    sb.deleteCharAt(sb.length() -1);
                }
            }
            else if(ch == '#'){
                sb.append(sb.toString());
            }
            else{   // ch == '%'
                sb.reverse();
            }
        }
        return sb.toString();
    }
}
/* Explanation
1. We will traverse over the input string and simulate
2. Use StringBuilder to store the result
3. When the current char is lower case character, append it to the result
4. If it is *, remove the last char, ensure that the current result is not empty and add that check too
5. If it is #, append the current result to the result, using sb.append()
Here, while appending we are using sb.append(sb.toString()) -> so, we are snapshoting the current content in a separate String and then appending it which is safer than doing sb.append(sb), as that's modifying the content while reading it, which is not safe
6. when the char is %, reverse the result
7. Finally return the result as a String
8. Time - O(n.2^n)
9. Space - O(2^n)
*/