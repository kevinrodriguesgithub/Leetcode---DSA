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
    public boolean isValidBST(TreeNode root) {
        
        return checkValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean checkValid(TreeNode root, Long minVal, Long maxVal){

        if(root == null){
            return true;
        }

        if(root.val >= maxVal || root.val <= minVal){
            return false;
        }
        return checkValid(root.left, minVal, (long)root.val) && checkValid(root.right, (long)root.val, maxVal);
    }
}
/* Explanation
1. For BST, every node on it's left subtree must be smaller than the current node, and every node on its right subtree must be greater than the current node
2. For every node we can say that it needs to be in a specific range, i.e node on the left should be smaller, and node on the right should be greater than the current node, but also if we are in left subtree then that node can't be greater than its parent's parent
For eg:    5
         3    8
       1  6  7  9
So, here even though each node on left and right is less than and greater than it's parent node respectively, but if we can node 6, is > 3 (its parent), but as 6 > 5, and 6 is in left subtree, so this doesn't make it a valid binary search tree
3. So, we will recursively traverse the BST starting with root node whose range would -Infinity to Infinity
4. Later for each left node, range would be curr min to val of it's parent, 
and for each right node, range would be val of it's parent to curr max
5. If at any point of time for any node, if it is out of the range, return false and stop, as it's not a valid BST
6. Time - O(n)
Space - O(h) - due to recursion call stack - O(log n) for balanced tree, O(n) for skewed tree
*/

/* Method 2 - Using InOrder traversal and store in list 
class Solution {
    public boolean isValidBST(TreeNode root) {
        
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);

        for(int i=1;i<list.size();i++){
            if(list.get(i) <= list.get(i-1)){
                return false;
            }
        }
        return true;
    }

    public void inOrder(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }

        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }
}       */
/*
1. Traverse in InOrder manner
2. Store the node values in a list
3. InOrder traversal of BST is in ascending order
4. Check that the list values are sorted, if any value is not, it means it was not a BST
*/