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
    public boolean isBalanced(TreeNode root) {
        return dfsHeight(root) != -1;      // if it doesn't return -1, it's balance
    }

    public int dfsHeight(TreeNode root){

        if(root == null){
            return 0;
        }

        int leftHeight = dfsHeight(root.left);  // recursively calcuate height for left subtree
        if(leftHeight == -1){
            return -1;
        }

        int rightHeight = dfsHeight(root.right); // recursively calcuate height for right subtree
        if(rightHeight == -1){
            return -1;
        }

        if(Math.abs(leftHeight - rightHeight) > 1){
            return -1;
        }

        return 1 + Math.max(leftHeight, rightHeight);
    }
}

/* Explanation
1. A binary tree is balanced if at every node the height difference between it's left subtree and right subtree is atmost 1
2. We will recursively calculate the height at each node, by finding height of it's left tree and right tree, at any point if the difference is > 1, we will return -1 indicating that the tree is not balanced at that node
3. Use dfsHeight() to recursively calculate height at every node
4. If the difference of height between left and right tree is not > 1, then the function will return the height of the tree at that node.
5. If at any node it returns -1, then the tree is not balanced and we will return false
*/