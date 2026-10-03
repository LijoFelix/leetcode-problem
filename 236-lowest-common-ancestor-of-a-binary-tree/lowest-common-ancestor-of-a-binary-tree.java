class Solution {
    public TreeNode lowestCommonAncestor(
            TreeNode root,
            TreeNode p,
            TreeNode q) {

        // Base case:
        // Either we reached the end,
        // or we found p or q.
        if (root == null || root == p || root == q) {
            return root;
        }

        // Search left subtree
        TreeNode left = lowestCommonAncestor(root.left, p, q);

        // Search right subtree
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // p and q are found in different subtrees
        if (left != null && right != null) {
            return root;
        }

        // Return whichever subtree contains p or q
        return left != null ? left : right;
    }
}