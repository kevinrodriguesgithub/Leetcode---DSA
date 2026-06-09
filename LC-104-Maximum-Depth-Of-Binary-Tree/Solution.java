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
    public int maxDepth(TreeNode root) {
        
        // We will use level order traversal technique - BFS
        Queue<TreeNode> queue = new LinkedList<>();

        int height = 0;
        if(root == null){
            return height;
        }
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                if(queue.peek().left != null){
                    queue.add(queue.peek().left);
                }
                if(queue.peek().right != null){
                    queue.add(queue.peek().right);
                }
                queue.poll();   // this element is done processing
            }
            height++;
        }
        return height; 

    // Solution using Recursive approach

    /*    if(root == null){
            return 0;
        }

        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);

        return 1 + Math.max(leftHeight, rightHeight);      */
    }
}

/* Explanation
1. We will use Queue to store the node values and traverse level by level - BFS
2. If the root itself is null, height is 0
3. Initialize height to 0
3. Add the first node to the queue
4. Now keep iterating until the queue is not empty
5. Calculate size of the queue, The size of the queue will be the number of elements on that level
6. Run a for loop for each element on that level, and if it has left or right trees, add it to the queue
7. Once we are out of for loop, that level is completed, so increment the height -> height++
8. Keep on iterating and once all the levels are traversed and the queue gets empty, we will have the height
*/