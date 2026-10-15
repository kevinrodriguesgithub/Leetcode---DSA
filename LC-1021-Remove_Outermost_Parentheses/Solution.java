class Solution {
    public String removeOuterParentheses(String s) {

        int n = s.length();
        int count = 0;
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(ch == '('){
                if(count !=0){
                    sb.append(ch);
                }
                count++;
            }
            else{       // ch == ')'
                count--;
                if(count != 0){
                    sb.append(ch);
                }
                
            }
        }
        return sb.toString();

     //   
    /*    int n = s.length();
        StringBuilder sb = new StringBuilder();
        int count1 = 0, count2 = 0;

        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(ch == '('){
                count1++;           // count1 stores '('
            }   
            else if(ch == ')'){
                count2++;           // count2 stores ')'
            }

            if(ch == '(' && count1 > 1){
                sb.append(ch);          // It's not outer, so include in the answer
            }
            else if(ch == ')' && count2 < count1){
                sb.append(ch);          // It's not outer, so include in the answer
            }

            if(count1 == count2){      // We found outer closing ')', reset count and continue
                count1 = 0;
                count2 = 0;
            }
        }
        return sb.toString();       */
    }
}
/* Explanation
1. We can use a count variable which will increment when the current char is "(" and it will decrement when current char is ")"
2. Iterate over the string
3. When the current char is "(" and count != 0, it means it's an inner opening parentheses, so we add it to the result and increment count
4. If it's ")", then we decrement the count and if the count != 0, then we add the inner closing parenthes to the result
5. When count would be 0, the first "(", will make count as 1 and that's something we don't want to add as it is the outer "("
6. Finally once the string is processed, our result will be in the string builder result
7. Time - O(n)
8. Space - O(n) 
*/