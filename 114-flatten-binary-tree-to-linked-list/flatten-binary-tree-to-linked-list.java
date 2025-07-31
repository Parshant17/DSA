class Solution {
    private TreeNode prev = null;

    public void flatten(TreeNode root) {
        if (root == null) return;

        flatten(root.right);  // step 1: right subtree
        flatten(root.left);   // step 2: left subtree

        root.right = prev;    // step 3: set right to previous node
        root.left = null;     // step 4: set left to null
        prev = root;          // step 5: update previous node
    }
}