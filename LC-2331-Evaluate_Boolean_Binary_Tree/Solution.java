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
    public boolean evaluateTree(TreeNode root) {
        
        // Leaf node -> 0 - false; 1 - True
        // Non-leaf -> 2 - OR; 3 - AND

        if(root.left == null && root.right == null){     // If it's a leaf node, return true if it's val is 1, if it's val is 0, return false;
            return root.val == 1;
        }

            // For non-leaf nodes
        if(root.val == 2){  
            return evaluateTree(root.left) || evaluateTree(root.right);
        }
        else if(root.val == 3){
            return evaluateTree(root.left) && evaluateTree(root.right);
        }

        return false;   // It will never reach here
    }
}

/* Explanation
1. The leaf nodes might have value either 0 or 1
2. Non-leaf nodes might have value either 2 or 3
3. Check if the current node is a leaf node, check if root.left == null && root.right == null, then it is leaf node, in that case we return true if the root node's val is 1, or else we return false
Also, here as the tree is full binary tree, so it will have either 0 or 2 children, so no need to check if root.right == null, bcz if root.left == null, it means root.right is also null, as the tree cannot contain only 1 child
4. If the current node is not a leaf node, now we need to check the conditions for non-leaf nodes which can have value either 2 or 3
5. If the current non-leaf node has value '2', then perform || (OR) operation on it's left and right children
6. Or else if the current non-leaf node has value '3', then perform && (AND) operation on it's left and right children
7. Thus we have covered all the conditions.
The line number 34 which return false is just for the function to return something, our code will never reach it, as the answer would be computed from previous steps
8. Time - O(n)
9. Space - O(n)
*/