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
    public TreeNode searchBST(TreeNode root, int val) {
        
        while(root != null){
            if(val > root.val){
                root = root.right;
            }
            else if(val < root.val){
                root = root.left;
            }
            else{
                return root;        // we found it
            }
        }
        return null;
    }
}

/* Explanation
1. In BST, left subtree nodes have values smaller than the root, and right subtree nodes have values greater than the root
2. While we haven't reached the left node (root != null), continue iterating and keep on checking if the current node value is >, < or, = or the value we want to search
3. If the value we are searching is > current node , we need to move root to it's right subtree; root = root.right
4. If the value we are searching is < current node val, we need to move root to it's left subtree; root = root.left
5. If the value is == current node val, we have found it, so simply return the current node
6. If we reach a leaf node and we haven't found the value, it means it does not exist, return null outside the while loop
*/