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
    public int kthSmallest(TreeNode root, int k) {
    
        // In-order traversal of BST, is in ascending order, so we can traverse it in In-order traversal
        int arr[] = new int[2];
        arr[0] = k;
        inOrderTraverse(root, arr);
        return arr[1];
    }

    public void inOrderTraverse(TreeNode root, int arr[]){

        if(root == null){
            return;
        }

        inOrderTraverse(root.left, arr);
        arr[0]--;
        if(arr[0] == 0){
            arr[1] = root.val;
        }
        inOrderTraverse(root.right, arr);
    }
}
/* Explanation
1. In-order traversal of binary search tree is in ascending order
2. We start traversing our BST in InOrder style
3. We will create an int[] arr of size 2, where arr[0] will store k, and arr[1] will store our answer
We need to pass this int[] arr for the recursive traverseFunction, as Java is call by value, so if we pass primitives it won't be updated
4. While traversing inOrder, when left tree call is done, and now we have the current node's value, we decrement the k value (i.e. arr[0] -- );
5. When k becomes 0, we have our kth smallest value, so store it in arr[1]
and we will return this
*/

// Using MaxHeap - but it's not the best of solution
/* 
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        traverseTree(root, maxHeap, k);
        return maxHeap.poll();
    }

    public void traverseTree(TreeNode root, PriorityQueue<Integer> maxHeap, int k){
        if(root == null){
            return;
        }

        maxHeap.offer(root.val);
        if(maxHeap.size() > k){
            maxHeap.poll();
        }
        traverseTree(root.left, maxHeap, k);
        traverseTree(root.right, maxHeap, k);
    }
}       */