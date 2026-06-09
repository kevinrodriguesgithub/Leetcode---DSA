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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();

        if(root == null){
            return ans;
        }
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> subList = new ArrayList<>();

            for(int i=0;i<size;i++){
                if(queue.peek().left != null){
                    queue.offer(queue.peek().left);
                }
                if(queue.peek().right != null){
                    queue.offer(queue.peek().right);
                }
                subList.add(queue.poll().val);
            }
            ans.add(subList);
        }
        return ans;
    }
}

/* Explanation:
1. We will use Queue to store the node values, and List<List<Integer>> to store the final answer
2. If the first node itself is root, return the list, as the answer would be empty
3. If not, add the first root node to the Queue
4. Now, keep on performing the iterations until Queue is not empty
5. At every step inside the while loop, we will calculate the size of the Queue. As that's the number of times the inner for loop will run and that many elements will be there at that level (level wise elements are stored in subList)
6. Inside the for loop, we will check if left tree exists for that node, if it does, push it to the queue
7. Similarly, do it for right tree as well
8. Poll the node value for which we performed this operations and add it's value to the subList; 
9. Notice, that the size of the subList would be the size we captured before entering this for loop
10. Once, for loop ends, subList contains list of elements at that level, add the subList to the answer [] 
11. Finally, when the queue is empty, we will have stored our level wise nodes in the ans list
12. At each step, the size of the queue will be the number of elements (nodes) on that particular level
Time - O(n) -> Each node is visited once
Space - O(n) -> Each node is stored once
*/