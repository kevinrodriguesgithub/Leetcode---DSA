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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        
        if(p == null && q == null){
            return true;            // both are same at this point
        }

        if(p == null || q == null){ // only 1 of them is null at this point
            return false;
        }

        if(p.val != q.val){         // values differ, return false
            return false;
        }

            // Current nodes match, check both subtrees together
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

/* Explanation
1. We will use recursion to check every corresponding node of both the trees
2. If the current values of p and q nodes in respective trees do not match, return false
3. If only one of the current node is null and the other is not null, it means the structure is different, return false
4. If both p and q nodes are null at a point, return true.
5. Recursively keep on checking and pass each node's left and each node's right
6. Continuosly it should match and keep on returning true for all the nodes, even if a single time it returns false based on the two conditions (mentioned in explanation point 2 and 3), then final answer will be false.
7. Time - O(n+m), where n and m are nodes each tree respectively
8. Space - O(h1+h2); O(log n + log m) for balanced tree, and O(n + m) for skewed tree
*/