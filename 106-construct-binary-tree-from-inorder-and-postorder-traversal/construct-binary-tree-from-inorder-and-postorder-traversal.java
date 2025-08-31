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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<inorder.length;i++) map.put(inorder[i],i);

        return helper(inorder,postorder,0,inorder.length-1,0,postorder.length-1,map);
    }
    private TreeNode helper(int[] inorder,int[] postorder,int inSt, int inEnd, int posSt, int posEnd, Map<Integer,Integer> map) {
        if(inSt > inEnd || posSt > posEnd) return null;

        int val = postorder[posEnd];
        TreeNode node = new TreeNode(val);
        int idx = map.get(val);
        int left = idx - inSt;

        node.left = helper(inorder, postorder, inSt, idx-1, posSt, posSt + left - 1, map);
        node.right = helper(inorder, postorder,idx+1, inEnd, posSt+left, posEnd - 1, map);

        return node;
    }
}