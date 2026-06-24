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
    int minVal;
    long secondMin;
    public int findSecondMinimumValue(TreeNode root) {

        minVal = root.val;
        secondMin = Long.MAX_VALUE;

        dfs(root);

        return secondMin == Long.MAX_VALUE ? -1 : (int) secondMin;
    }

    public void dfs(TreeNode root){
        if(root == null){
            return;
        }

        if(root.val > minVal){
            secondMin = Math.min(secondMin, root.val);
        }
        else if(root.val == minVal){
            dfs(root.left);
            dfs(root.right);
        }

    }
}
/* Exlanation
1. Root is always going to be the minimum value as per the description, bcz if it has 2 child nodes, root's value is min() among those two
2. Assign root value to int minVal variable, initialize secondMin as Long.MAX_VALUE
3. Now keep traversing the tree, if the node's value is > minVal, then we can update the secondMin, update it secondMin = Math.min(secondMin, node.val)
4. If it's not, keep traversing root's left and root's right
5. If the secondMin value has not changed, it means all nodes have same value, so return -1, if it has changed, return the secondMin
6. Time - O(n) 
7. Space - O(h) - Recursion call stack, O(log n) for balanced tree, O(n) for skewed tree
*/

// Method 2
/*
class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        Set<Integer> set = new HashSet<>();
        traverseTree(root, maxHeap, set);

        if(maxHeap.size() < 2){
            return -1;
        }
        return maxHeap.poll();
    }

    public void traverseTree(TreeNode root, PriorityQueue<Integer> maxHeap, Set<Integer> set){

        if(root == null){
            return;
        }

        if(!set.contains(root.val)){
            maxHeap.offer(root.val);
            set.add(root.val);
        }

        if(maxHeap.size() > 2){
            maxHeap.poll();
        }

        traverseTree(root.left, maxHeap, set);
        traverseTree(root.right, maxHeap, set);
    }
}   */

/* Explanation
1. One simple approach would be to traverse the tree entirely and store unique values in a heap and return kth minimum (2nd minimum)
*/