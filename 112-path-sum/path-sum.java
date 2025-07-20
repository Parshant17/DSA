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
 class Pair{
 TreeNode node;
 int currentSum;
 Pair(TreeNode node, int currentSum){
     this.node = node;
     this.currentSum = currentSum;
 }
 }
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }
    Stack<Pair> stack = new Stack<>();
    stack.push(new Pair(root, 0));
    while(!stack.isEmpty()){
        Pair pair = stack.pop();
        TreeNode node = pair.node;
        int currentSum = pair.currentSum;
        currentSum = currentSum + node.val;
        if(node.left == null && node.right == null){
            if(currentSum == targetSum){
                return true;
            }
        }
        if(node.left != null){
            stack.push(new Pair(node.left, currentSum));
        }
         if(node.right != null){
            stack.push(new Pair(node.right, currentSum));
        }
    }    
    return false;
    }
}