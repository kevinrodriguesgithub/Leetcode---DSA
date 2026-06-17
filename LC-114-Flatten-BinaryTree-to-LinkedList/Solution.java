/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void flatten(TreeNode root) {

        TreeNode curr = root;
        while(curr != null){
            if(curr.left != null){
                TreeNode prev = curr.left;
                while(prev.right != null){
                    prev = prev.right;
                }
                prev.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }
}
/* Explanation
1. From our observation, we can say that the right subtree needs to be attached to the rightmost node from the left subtree
2. So we initiliaze curr as the root node
3. Now if left node exists go in the if condition
4. Store the curr.left in prev node
5. Now we are in left subtree, go to the extreme right node in the left subtree
6. Now, attach the curr.right subtree to the extreme right node we reached in left subtree
7. Attach curr.left as the right in the curr node
8. Mark curr.left as null, as each node's left in our LinkedList we want to be null
9. Move the curr pointer ahead by curr = curr.right
10. Time - O(n); Space - O(1)
*/


// Using Stack 
/* 
class Solution {
    public void flatten(TreeNode root) {

     // Using Stack
        Stack<TreeNode> stack = new Stack<>();

        if(root == null){
            return;
        }   
        stack.push(root);

        TreeNode curr = root;
        while(!stack.isEmpty()){

            curr = stack.pop();

            if(curr.right != null){
                stack.push(curr.right);
            } 
            if(curr.left != null){
                stack.push(curr.left);
            }

            if(!stack.isEmpty()){
                curr.right = stack.peek();
            }
            curr.left = null;
        }
    }
}       */

/*
class Solution {
    public void flatten(TreeNode root) {
        
    // Using extra space- Iterate the Tree in preOrder manner and store in an arraylist. Now in the arraylist, assign left value to null and right to the next element in the list, as that's how we want the expected output
        List<TreeNode> list = new ArrayList<>();
        preOrder(root, list);

        for(int i=0;i<list.size() -1; i++){
            list.get(i).left = null;
            list.get(i).right = list.get(i+1);
        }
    }

    public void preOrder(TreeNode root, List<TreeNode> list){
        if(root == null){
            return;
        }

        list.add(root);
        preOrder(root.left, list);
        preOrder(root.right, list);
    }
}
*/