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
    public void flatten(TreeNode root) {
        if(root == null) return;
        List<TreeNode> ans = new ArrayList<>();

        preOrder(root,ans);

        for(int i=0;i<ans.size()-1;i++){
            ans.get(i).left = null;
            ans.get(i).right = ans.get(i+1);
        }
    }

    private void preOrder(TreeNode root, List<TreeNode> ans){
        if(root == null) return;

        ans.add(root);
        preOrder(root.left,ans);
        preOrder(root.right,ans);
    }
}