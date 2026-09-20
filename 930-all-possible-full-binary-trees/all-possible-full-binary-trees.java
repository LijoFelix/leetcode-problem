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
    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> ans=new ArrayList<>();
        if(n%2==0){
            return ans;
        }
        if(n==1){
            ans.add(new TreeNode(0));
            return ans;
        }
        for(int i=1;i<n;i+=2){
            int lnodes=i;
            int rnodes=n-1-i;
            List<TreeNode> lsubtrees=allPossibleFBT(lnodes);
            List<TreeNode> rsubtrees=allPossibleFBT(rnodes);
            for(TreeNode l:lsubtrees){
                for(TreeNode r:rsubtrees){
                    TreeNode root=new TreeNode(0);
                    root.left=l;
                    root.right=r;
                    ans.add(root);
                }
            }
        }
        return ans;
    }
}