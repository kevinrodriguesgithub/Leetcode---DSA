/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        while(root != null){
            if(p.val < root.val && q.val < root.val){
                root = root.left;
            }
            else if(p.val > root.val && q.val > root.val){
                root = root.right;
            }
            else{
                return root;
            }
        }
        return root;        // will never reach here
    }
}

/* Explanation
1. Traverse the tree through the root node
2. If p < root and q > root, it means, p is in left subtree and q is in right subtree, so consequently the current node will be the lowest common ancestor
3. If p < root and q < root, it means we need to move to the left subtree 
4. Similarly, if p > root and q > root, we need to move to the right subtree
5. If point 3 or point 4 is not satisfied, it means either the current node is the LCA as per point 2 or one of the p or q values is equal to the current node, in that case as well, the current node becomes the LCA
6. Time - O(h), h is height of the tree, for balanced tree it would O(log n), for skewed O(n)
7. Space - O(1)
*/