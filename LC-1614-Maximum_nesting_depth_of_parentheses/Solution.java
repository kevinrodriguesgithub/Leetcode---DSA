class Solution {
    public int maxDepth(String s) {
        
        int n = s.length();
        Stack<Character> stack = new Stack<>();
        int depth = 0;

        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(ch == '('){
                stack.push(ch);
            }
            else if(ch == ')'){
                depth = Math.max(depth, stack.size());
                stack.pop();
            }
        }
        return depth;
    }
}
/* Explanation
1. Since the string s contains a valid parentheses, we can use a stack to add the '(' onto the stack and the moment we encounter the ')', we can take a count of stack's size at that point, which is the depth of the parentheses. 
Remember to pop out one '(' as we encounter the ')'
2. Initialize a stack
3. Use for loop to iterate over String s
4. If the character is '(', push it onto the stack
5. If the character is ')', find out the size of the stack and update depth as depth = Math.max(depth, stack.size())
6. All the other characters will be ignored
7. Finally return the depth
8. Time - O(n)
9. Space - O(n)
*/