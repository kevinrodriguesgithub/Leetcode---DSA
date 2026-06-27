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
    
    int minDiff = Integer.MAX_VALUE;
    TreeNode prev = null;

    public int getMinimumDifference(TreeNode root) {
        
        traverse(root);
        return minDiff;
    }

    public void traverse(TreeNode root){
        if(root == null){
            return;
        }

        traverse(root.left);
        
        if(prev != null){
            minDiff = Math.min(minDiff, root.val - prev.val);
        }
        prev = root;
        traverse(root.right);
    }
}
/* Explanation.
1. InOrder traversal of BST will give node values in a sorted order.
2. Instead of storing these values in a list and then comparing adjacent values of a list,
we can store only the previous node's value and compare the current node value with prev node and check the difference
3. Assign prev to null at the start, and while performing inOrder traversal, check if prev != null, update minDiff = Math.min(minDiff, root.val - prev.val)
4. Before proceeding to the right, assign current node to the prev node
5. Once the inOrder traversal is performed, you will have the minimum value in minDiff
6. Time - O(n)
7. Space - O(1)


*/

/* 
class Solution {

    public int getMinimumDifference(TreeNode root) {
        
        int minDiff = Integer.MAX_VALUE;
        List<Integer> list = new ArrayList<>();
        traverse(root, list);
        for(int i=1;i<list.size();i++){
            int diff = list.get(i) - list.get(i-1);
            minDiff = Math.min(minDiff, diff);
        }
        return minDiff;
    }

    public void traverse(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }

        traverse(root.left, list);
        list.add(root.val);
        traverse(root.right, list);
    }
}   */
/* Explanation
1. Traverse the BST in inOrder style, and the nodes you encounter will be in ascending order
2. Store them in a list
3. Traverse this list and compare neighbours, and at every step compare the difference with the globalMin
4. Update globalMin if necessary
5. Time - O(n)
6. Space - O(n)
*/