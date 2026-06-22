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

    public int sumNumbers(TreeNode root) {
        return calculate(root, 0);
    }

    public int calculate(TreeNode root,int num){

        if(root == null){
            return 0;
        }

        num = num * 10 + root.val;
        if(root.left == null && root.right == null){
            return num;
        }
        
        return calculate(root.left, num) + calculate(root.right, num);
    }
}
/* Explanation
1. We need to add the num when we reach the leaf node of a path, every time we can append the number to the path by performing, num * 10 + current node val
2. If the current node is leaf node, return the num
3. Recursively calculate for left and right node and add the numbers
4. Notice that we are adding the numbers only when we reach the leaf node, if not, we keep on appending the path node val to the num
*/