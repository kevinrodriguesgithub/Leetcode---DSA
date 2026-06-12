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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        
        // From the sequence we observe, what strikes is that we need to process post-order traversal; No actually any traversal is fine, but pass the left node first for traversal, and just check for the root node

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        findLeaf(root1, list1);
        findLeaf(root2, list2);

        return list1.equals(list2);
    }

    public void findLeaf(TreeNode root, List<Integer> list){

        if(root == null){
            return;
        }

        findLeaf(root.left, list);
        if(root.left == null && root.right == null){    // leaf node
            list.add(root.val);
        }        
        findLeaf(root.right, list);
        
    }
}

/* Explanation:
1. We need to traverse the tree (from left to right - so pass root.left first or we can say any dfs traversal is fine - preOrder, inOrder, postOrder), and check if the current node is a leaf node, if it is add it to the list
2. Process both the trees and store it's leaf nodes in two different lists respectively
3. Compare the two lists and both are equal, then return true, else return false
4. Time - O(n+m), where n is nodes in tree1 and m is nodes in tree2
5. Space - O(n + m) again, as let's say in worst case its a balanced binary tree and half the nodes are leaf nodes, so  n/2 + m/2, but we ignore constants in complexity
*/