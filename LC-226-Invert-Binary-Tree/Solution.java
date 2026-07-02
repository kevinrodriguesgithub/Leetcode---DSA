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
    public TreeNode invertTree(TreeNode root) {
        
        if(root == null){
            return null;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
/* Explanation
1. When you are standing at a node, swap it's left and right child
2. Recursively, keep inverting the subtree
3. For eg: when you are root with val 4, swap it's left (2) and right child(7)
Then when u are at 7, swap it's left (6) and right(9)...and so on
4. Once all the nodes are traversed, our tree is inverted
5. Time - O(n)
6. Space - O(h) - Due to recursion call stack; where h is heght of tree 
*/