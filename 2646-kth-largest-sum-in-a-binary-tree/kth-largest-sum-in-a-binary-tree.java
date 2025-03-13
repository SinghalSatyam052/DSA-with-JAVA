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
    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Long> level = new ArrayList<>();

        queue.add(root);

        while(!queue.isEmpty()){
            int n = queue.size();
            long sum =0;

            for(int i=0;i<n;i++){
                TreeNode curr = queue.poll();
                sum += curr.val;

                if(curr.left != null) queue.add(curr.left);
                if(curr.right != null) queue.add(curr.right);
            }

            level.add(sum);
        }

        if(level.size()<k) return -1;
        
        Collections.sort(level,Collections.reverseOrder());

        return level.get(k-1);
    }
}