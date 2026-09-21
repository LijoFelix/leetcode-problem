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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        Deque<TreeNode> st=new ArrayDeque<>();
        for(int num:nums){
            TreeNode node=new TreeNode(num);
            while(!st.isEmpty()&&st.peek().val<num){
                node.left=st.pop();
            }
            if(!st.isEmpty()){
                st.peek().right=node;
            }
            st.push(node);
        }
        return st.isEmpty()?null:st.peekLast();
    }
}