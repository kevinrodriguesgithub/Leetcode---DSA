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
    public List<Integer> postorderTraversal(TreeNode root) {
        
        List<Integer> list = new ArrayList<>();
        postOrder(root, list);

        return list;
    }

    public void postOrder(TreeNode node, List<Integer> list){

        if(node == null){
            return;
        }

        postOrder(node.left, list);
        postOrder(node.right, list);
        list.add(node.val);
    }
}

/* Explanation
1. We use a postOrder() method which we will call recursively
2. For first call, pass the TreeNode root, and the list to the postOrder() function
3. If the current node is null, simply return
4. If not, recursively call the function on node.left, list; Then on node.right, list; Then finally add the node.val to the list.
5. We have successfully traversed the binary tree in post order
6. Time Complexity - O(n) -> As each node is visited once
7. Space Complexity - O(n) -> As each node's value is stored in the list 
*/