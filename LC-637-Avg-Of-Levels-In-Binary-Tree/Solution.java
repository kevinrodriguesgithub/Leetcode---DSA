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
    public List<Double> averageOfLevels(TreeNode root) {
        
        List<Double> ans = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();

        if(root == null){
            return ans;
        }
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();        // no of nodes at this level
            double sum = 0;
            for(int i=0;i<size;i++){
                if(queue.peek().left != null){
                    queue.offer(queue.peek().left);
                }
                if(queue.peek().right != null){
                    queue.offer(queue.peek().right);
                }
                sum += queue.poll().val;
            }
            double avg = sum / (double)size;
            ans.add(avg);
        }
        return ans;
    }
}
/* Explanation
1. Perform BFS level by level traversal, and at each level maintain sum of all the values of the nodes and find out avg
2. Time - O(n) - Each node is visited once
3 Space - O(m) - where m is maximum numbers of nodes in any level 
*/