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
    public int goodNodes(TreeNode root) {

        int count[] = new int[1];
        int currMax = root.val;         // Had initialized it to 0, but won't work for negative values, so better to initialize with value of root node
        dfsHelper(root, currMax, count);
        return count[0];
    }

    public void dfsHelper(TreeNode root, int currMax, int[] count){
        
        if(root == null){
            return;
        }

        if(root.val >= currMax){
            currMax = root.val;
            count[0]++;
        }

        dfsHelper(root.left, currMax, count);
        dfsHelper(root.right, currMax, count);
    }
}

/* Explanation:
1. A node is a good node, if it's value is >= the max value of the node we have seen so far in the path
2. We use count[] array and not int count as java is pass by value, so value of count won't be updated and available unless we return it from the function, hence array is a better choice
3. We initialize the currMax with the value of the root node
4. At every node, we check if it's value is >= the currMax, if it is then it is a good node and we update the currMax, and increment the count
5. Recursively traverse the left and right nodes.
6. Notice, that when we update the currMax, it's applicable only to that node and anything below it (recursive calls). 
7. After traversing the entire tree we will have our answer in count[0]
8. Time - O(n) - We traverse each node
9. Space - O(h), hieght of the tree
*/