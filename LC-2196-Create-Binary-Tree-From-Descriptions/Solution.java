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
    public TreeNode createBinaryTree(int[][] descriptions) {
        
        Map<Integer, TreeNode> map = new HashMap<>();
        Map<Integer, Boolean> childMap = new HashMap<>();

        for(int[] desc: descriptions){
            int parent = desc[0];
            int child = desc[1];
            int isLeft = desc[2];

            TreeNode parentNode = null;
            TreeNode childNode = null;

            if(!map.containsKey(parent)){
                parentNode = new TreeNode(parent);
                map.put(parent, parentNode);
            }
            else{
                parentNode = map.get(parent);
            }

            if(!map.containsKey(child)){
                childNode = new TreeNode(child);
                map.put(child, childNode);
            }
            else{
                childNode = map.get(child);
            }
            childMap.put(child, true);      // every childNode will def have parent node

            if(isLeft == 1){
                parentNode.left = childNode;
            }
            else{
                parentNode.right = childNode;
            }
        }

        TreeNode root = null;
        for(int p: map.keySet()){
            if(!childMap.containsKey(p)){
                root = map.get(p);
                break;
            }
        }
        return root;
    }
}

/* Explanation
1. To construct binary tree, use map to store the nodes. Use a map of <int, TreeNode> -> where int will be the val of the node, and TreeNode will be that node
2. In the input descriptions[][], we have each int[] of size 3
int [0] = parentVal, int[1] = childVal, int[2] = isLeft val
3. Start iterating over the input descriptions in a for loop
4. Create a new treenode with a parent value, only if you haven't created the treenode with this value, if it's already created, then simply fetch that node.
And every time you create a new node, add it to map, so that next time you know that node of this value already exists
5. Similarly, store child node value in the same map, and create new node if it doesn't exists, and if it does exists, simply fetch the node from the map
6. Additionally, have a childMap, which will store <int, boolean> and after every childNode, we will mark this childNode with true value in that map. True value indicating that it has parent
This will help us later to identify which nodes are child (have parent as true), as later we need to return the root node, the node which won't have parent.
7. Now check if isLeft == 1, if it is place this childNode to the left of parentNode, if isLeft == 0, place the childNode to the right of parentNode
8. Now after the for loop, we have constructed the tree, but we need to know which is the root node
9. Iterate over the map, the map has all the nodes, and while iterating check if this value is not present in childMap. 
In childMap we only have nodes which have a parent, so we will find only 1 node while iterating over the map which is not present in childMap, once we find it, immediately break and return that value node as our root
10. Time - O(n), Space - O(n)
*/