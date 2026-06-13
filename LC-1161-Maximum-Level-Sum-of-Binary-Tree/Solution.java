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
    public int maxLevelSum(TreeNode root) {
        
        // We will use BFS - breadth first search, for level by level traversal
        int level = 1, ansLevel = 1;
        int maxSum = Integer.MIN_VALUE;

        Queue<TreeNode> queue = new LinkedList<>();

        if(root == null){           // based on constraints this will never occur
            return 0;
        }
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            int sum = 0;
            for(int i=0;i<size;i++){
                if(queue.peek().left != null){
                    queue.add(queue.peek().left);
                }
                if(queue.peek().right != null){
                    queue.add(queue.peek().right);
                }
                sum += queue.poll().val;
            }
            if(sum > maxSum){
                maxSum = sum;
                ansLevel = level;
            }
            level++;
        }
        return ansLevel;
    }
}

/* Explanation
1. We will traverse the tree level by level - Breadth first search
2. We use a queue and add the root node to the queue
3. We continue iterating until queue is not empty
4. Calculate the size of the queue (no of nodes in queue at this point), the size would be the numbers of nodes at that level. 
5. Use for loop, to iterate over the nodes in the queue at this point and add the value of a sum variable
6. Keep checking if the node contains left and right subtrees, if it contains, add it to the queue for further level processing in next iteration
7. Check if the sum > maxSum, if it is update maxSum, and update the ansLevel as well and assign current level to it and that's our answer till this point
8. Increment level++ after each level traversal
9. Finally, after all the levels of the tree are traversed, we will have our answer in ansLevel variable
10. Time - O(n) - Each node is visited once
11. Space - O(n) - Queue holds all nodes of current level at any point. 
*/