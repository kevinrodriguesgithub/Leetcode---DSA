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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        
        if(subRoot == null){
            return true;
        }

        if(root == null && subRoot == null){
            return true;
        }

        if(root == null){
            return false;
        }

        if(sameTree(root, subRoot)){
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean sameTree(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null){
            return true;
        }
        if(root1 == null || root2 == null){     // only 1 of them is null
            return false;
        }

        if(root1.val != root2.val){
            return false;
        }

        return sameTree(root1.left, root2.left) && sameTree(root1.right, root2.right);
    }
}

/* Explanation
1. At every node in root, we recurively pass the current root node and the subRoot node to a helper function which will check whether these 2 trees are the same (Same Tree)
2. The helper function is same Tree, much like the sameTree problem we have solved
3. In same tree, if both nodes have reached null, we return true
  If only 1 of them is null, return false
  If the values of the both the current nodes in those two trees do not match, return false
  Recursively, keep checking for left and right subtrees, even if 1 condition fails, the trees are not same
4. We will use this helper function and recursively pass root and subRoot to check if they are same, even if we found 1 such occurence, we need to return true
 Hence, we have wrapped sameTree(root, subRoot) inside if() condition, so that even if once it's true, we have found an instance
5. Recursively pass the left node and subRoot to isSubTree() and pass right node and subRoot to isSubTree()
6. If subRoot is null, we can return true
7. If subRoot and root both are null, we can return true
8. But if only root is null, and subRoot is not, we need to return false
9. Time - O(n * m) where n is number of nodes in root tree and m is number of nodes in subRoot tree
10. Space - O(n+m)
*/