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
    public long kthLargestLevelSum(TreeNode root, int k) {
        
        // we will traverse level by level - bfs - calculate sums and store it in min heap of size k

        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null){
            return -1;
        } 
        queue.offer(root);

        PriorityQueue<Long> minHeap = new PriorityQueue<>();   // to store the sum 

        while(!queue.isEmpty()){
            int size = queue.size();
            long levelSum = 0;
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                levelSum += node.val;
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            minHeap.offer(levelSum);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
        if(minHeap.size() < k){
            return -1;
        }
        return minHeap.poll();
    }
}

/* Explanation
1. We will use BFS and traverse level by level, like other problems we have solved and store the levelSum in minHeap of size k
2. Whenever the size of minHeap gets > k, poll() the top element as we want to keep it of size k, so that kth largest is at the top
3. While iterating we can keep a count of the levels in the tree, as we also want to ensure that if there are fewers than k levels, then we return -1;
But instead of that, we can simply check if minHeap.size() < k, then it means there were fewer levels than K, as we poll() out when minHeap.size() exceeds > k; so finally at the end minHeap.size() will be exactly equal to k, but if its smaller then, we there were fewer levels, so we return -1.
4. As we store the levelSum's in minHeap of size k, the kth largest sum will be at the top of the minHeap, poll() it out and return as the answer
5. Time - O(nlogk) : O(n) to traverse the tree, O(nlogk) for minHeap
6. Space - O(n+k): O(n) for queue, and O(k) for minHeap
*/