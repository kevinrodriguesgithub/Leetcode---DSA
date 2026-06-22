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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }

        if(root.val == targetSum && root.left == null && root.right == null){
            return true;
        }

        if(root.left != null){
            root.left.val += root.val;
        }

        if(root.right != null){
            root.right.val += root.val;
        }
        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }
}
/* Explanation
1. We need to find if a path exists from root to leaf node where sum is equal to targetSum
2. Base case would be when root == null, return false
3. We will recursively calculate the sum for left and right path at each node
4. At every node, we will add curr val and it's left and set it to it's left node; and curr val added to it's right will be set to right node's value
5. When value of node we reached is equal to targetSum and if this node doesn't have left and right child, it means it's a leaft node and we have found a sum
6. The short circuit || helps to check that even if one path is found which returns true, it will return true to all its above calls.
7. Time - O(n) Tree is traversed once
8. Space - O(h) Recursion call stack - O(log n) for balanced tree, O(n) for skewed tree
*/