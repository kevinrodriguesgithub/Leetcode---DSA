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
    public List<Integer> preorderTraversal(TreeNode root) {
        
        List<Integer> list = new ArrayList<>();
        preOrder(root, list);

        return list;
    }

    public void preOrder(TreeNode node, List<Integer> list){

        if(node == null){
            return;
        }

        list.add(node.val);
        preOrder(node.left, list);
        preOrder(node.right, list);
    }
}

/* Explanation
1. For PreOrder, we follow - value of the node, left subtree, right subtree
2. Create a function preOrder() for which we pass pass the tree (node) and the list in which we are storing the answer
3. At every recursive call, we will check if the current node is null, it is a leaf node, so simply return
4. If not, then fetch the value of the node and add it to the ans list, then recursively call the left subtree and then the right subtree
*/