class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int value) {
        stack.push(value);

        if(minStack.isEmpty() || value <= minStack.peek()){
            minStack.push(value);
        }
    }
    
    public void pop() {
        int rem = stack.pop();

        if(rem == minStack.peek()){
            minStack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

 /* Explanation
1. Regular push, pop, peek would work fine, but for getMin(), we need to return the minimum in O(1)
2. Along with our stack, We will also maintain a minStack which will help to fetch the getMin() value in O(1)
3. For MinStack() method, simply initialize both the stacks
4. For push(), push the value in stack, and at the same time check if this value is <= to the top of minStack; If it is means it will be the minimum value, so push it to minStack as well. Remember to add the edge case, checking whether minStack.isEmpty()
5. For pop(), pop the element from top of the stack, and also check if this value is equal to the top of minStack, if it is, it needs to be removed from minStack as well. Bcz the whole purpose of having minStack is that it stored the minimum element at that time, so if we pop from stack and it is not equal to minStack.peek(), it means the popped element is > minStack.peek(). 
And condition can be verified from push operation itself, bcz if the element > minStack.peek(), only in that case, we do not push that element to minStack.
6. For top(), simply return stack.peek() to return top of the stack
7. Now for getMin(), we can return minStack.peek() as the whole purpose of having minStack was to return the minimum value at that point
 */