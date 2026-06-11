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
    public int diameterOfBinaryTree(TreeNode root) {
        
        int diameter [] = new int[1];
        calculateHeight(root, diameter);
        return diameter[0];
    }

    public int calculateHeight(TreeNode root, int[] diameter){
        
        if(root == null){
            return 0;
        }

        int leftHeight = calculateHeight(root.left, diameter);
        int rightHeight = calculateHeight(root.right, diameter);

        diameter[0] = Math.max(diameter[0], leftHeight + rightHeight);

        return 1 + Math.max(leftHeight, rightHeight);
    }
}

/* Explanation
1. We had to use int[] and not int for diameter, bcz Java is pass by value, so int won't be updated across recursive calls, Array is an object so it's reference is shared

At each Node, the diameter passing through it, will be equal to it's leftHeight + rightHeight
2. We recursively calculate the height of left subtree and right subtree at each node
3. The path through each node will have it's diameter (length) as leftHeight + rightHeight
If it is greater than the current max diameter we have found, update it
4. We return the node's height to it's parent, so the parent can use it for it's own calculation
5. Time - O(n) -> Every node is visited once
6. Space - O(h) -> where h is height of the tree
*/