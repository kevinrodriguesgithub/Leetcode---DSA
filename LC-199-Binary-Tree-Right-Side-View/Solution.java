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
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> ans = new ArrayList<>();
        traverseBfs(root, ans);

        return ans;
    }

    public void traverseBfs(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                if(queue.peek().left != null){
                    queue.offer(queue.peek().left);
                }
                if(queue.peek().right != null){
                    queue.offer(queue.peek().right);
                }
                int rem = queue.poll().val;
                if(i == size - 1){    // only add the last from this iteration which will be right most node at that level
                    list.add(rem);
                }
            }
        }
    }
}

/* Explanation
1. My first thought process was traverse the right nodes of the right subtree and add it to the answer list, then traverse the tree using bfs level by level and barring the level 1 (root), consider those levels which have only 1 node, as only that can be visible from right side view
But the issue was at any level, it can have 1 node only which we will consider, but the possibility is it can be right side node and the left can be empty, so in that scenario we will duplicate it's count. So I changed my approach a bit

2. Traverse the tree using BFS - level by level
3. At every level, we check if left and right sub tree exists and we add it to the queue, and we pop the current node; continue doing that 
4. But the last node which we iterate over at every level, will be the right most node on that level, so we just need to add that node to our answer
5. So, in the for loop where we iterate on nodes at a level, only add the right most node to our answer list, i.e. the last node on that level in the queue. So, whenever i == size -1, add that node
6. Thus using BFS we can solve this
7. Time - O(n) - Each node traversed once
8. Space - O(n) - Queue holds n/2 nodes at last level in balanced tree

If it was left side view, instead of i == size -1, we would have checked i == 0 and added that node
*/