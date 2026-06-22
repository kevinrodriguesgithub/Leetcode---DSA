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
    public boolean isSymmetric(TreeNode root) {
        
        return checkTree(root, root);
    }

    public boolean checkTree(TreeNode root1, TreeNode root2){

        if(root1 == null && root2 == null){
            return true;
        }

        if(root1 == null || root2 == null){     // only 1 of them is null
            return false;
        }

        if(root1.val != root2.val){
            return false;
        }

        return checkTree(root1.left, root2.right) && checkTree(root1.right, root2.left);
    }
}
/* Explanation
1. Thought process, start from root node, for left subtree, use preOrder iterate node -> left -> right
For right subtree, iterate node -> right -> left

2. Later, I used the same technique I have used in LC-100-Same Tree
3. Start with 2 pointers at the root node, one pointer will go in left tree and other in right tree. At every point left and right should be similar - That means node's value should be same and when left's left would be right's right and vice versa - left's right would be right's left
4. If both have reached null, then return true
5. If only one of them has reached null, return false as it's not symmetric
6. At any point if node values do not match, return false
7. Recursively calculate, but remebers to pass root1.left, root2. right and then root1.right, root2.left
8. Time - O(n)
9. Space - O(h) Recursion call stack - Balanced tree - O(log n), skewed tree - O(n)
*/