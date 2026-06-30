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
    public TreeNode deleteNode(TreeNode root, int key) {
        
        if(root == null){
            return null;
        }

        if(root.val == key){
            return helper(root);
        }

        TreeNode dummy = root;
        while(root != null){
            if(key < root.val){     // search in left sub tree
                if(root.left != null && root.left.val == key){
                    root.left = helper(root.left);      // for eg 1: we connect 5's left to 2
                }
                else{
                    root = root.left;
                }
            }
            else{                   // search in right sub tree
                if(root.right != null && root.right.val == key){
                    root.right = helper(root.right);
                    break;
                }
                else{
                    root = root.right;
                }
            }
        }
        return dummy;
    }

    TreeNode helper(TreeNode root){
        if(root.left == null){      // only right child exists
            return root.right;
        }
        else if(root.right == null){
            return root.left;          // only left child exists
        }
            // else both child exists       , we attach the right child to the rightmost of left child
        TreeNode rightChild = root.right;
        TreeNode lastRightOfLeft = findLastRight(root.left);
        lastRightOfLeft.right = rightChild;
        return root.left;       // we return left of the node we deleted, and now the right side of node that's deleted is attached to it's left child's rightmost node's right side
    }

    TreeNode findLastRight(TreeNode root){
        if(root.right == null){
            return root;
        }
        return findLastRight(root.right);
    }
}
// For understading reference - https://www.youtube.com/watch?v=kouxiP_H5WE