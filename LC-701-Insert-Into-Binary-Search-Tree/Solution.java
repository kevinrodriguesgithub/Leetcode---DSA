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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        
        if(root == null){
            return new TreeNode(val);
        }

        TreeNode start = root;
        TreeNode prev = root;
        while(root != null){
            prev = root;
            if(val > root.val){
                root = root.right;
            }
            else if(val < root.val){
                root = root.left;
            }
        }
        if(val < prev.val){
            prev.left = new TreeNode(val);
        }
        else{
            prev.right = new TreeNode(val);
        }

        return start;
    }
}

/* Explanation
1. A simple logic would be keep traverse the BST and on the leaf node, atatch this new node
2. Edge case, boundary condition would be, if the current tree itself is null, simply insert this new node and return
3. We will iterate the BST until we reach the leaf node,
so we keep on checking the condition where val < root.val, move to the left subtree
if val > root.val, move to the right subtree
4. At this same time, before moving to the left or right, store the current root node in a prev node, as when root becomes null, we can use this prev node to insert the new node at leaf
5. Once, root node becomes null, check if the val we want to insert is < or > than the prev node.val, accordingly insert it to it's left or right 
6. Also, before starting the iteration store the root node in a start node variable and return the start node at the end when the operations are done, as we need to return the entire BST
7. Time - O(h), O(log n) for balanced tree, and O(n) for skewed tree
 Space - O(1)
*/