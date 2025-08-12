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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null) return new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();

        queue.offer(root);

        while(!queue.isEmpty()){
            int n = queue.size();
            
            List<Integer> level = new ArrayList<>();

            for(int i=0;i<n;i++){
                TreeNode temp = queue.poll();

                if(temp.left != null ) queue.offer(temp.left);
                if(temp.right != null ) queue.offer(temp.right);

                level.add(temp.val);
            }
            result.add(level);
        }
        Collections.reverse(result);

        return result;
    }
}