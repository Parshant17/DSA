/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case: if root is null or root is one of p or q
        if (root == null || root == p || root == q) {
            return root;
        }
        
        // Recursively search in left and right subtrees
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        // If both left and right found nodes, current root is LCA
        if (left != null && right != null) {
            return root;
        }
        
        // Return whichever subtree found a node (or null if neither did)
        return left != null ? left : right;
    }
}