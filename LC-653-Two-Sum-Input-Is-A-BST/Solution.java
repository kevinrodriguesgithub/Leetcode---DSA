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
    public boolean findTarget(TreeNode root, int k) {
        
        Set<Integer> set = new HashSet<>();
        return traverseTree(root, k, set);
    }

    public boolean traverseTree(TreeNode root, int k, Set<Integer> set){
        if(root == null){
            return false;
        }

        int value = root.val;
        if(set.contains(k - value)){
            return true;
        }
        set.add(value);

        return traverseTree(root.left, k, set) || traverseTree(root.right, k, set);
    }
}
/* Explanation
1. Traverse the tree and keep adding the node values in a Set
2. While adding the node values to the set, we check if (k - currVal) exists, if it does it means you found a pair
3. Time - O(n); Space - O(n)

4. Another approach, would be to traverse the tree in InOrder manner and as Inorder traversal of BST is in ascending order, so you store those values in an array and use 2 pointer technique, but again that's also O(n) time and O(n) space
*/