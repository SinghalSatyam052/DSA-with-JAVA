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
    int num;
    Pair(TreeNode node, int num){
        this.node = node;
        this.num = num;
    }
 }
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root,0));

        int ans = 0;

        while(!queue.isEmpty()){
            int n = queue.size();
            int min = queue.peek().num;
            int first = 0, last = 0;

            for(int i=0;i<n;i++){
                Pair curr = queue.poll();
                int currId = curr.num - min;
                TreeNode curNode = curr.node;

                if(i == 0) first = currId;
                if(i == n-1) last = currId;

                if(curNode.left != null) queue.offer(new Pair(curNode.left,2*currId+1));
                if(curNode.right != null) queue.offer(new Pair(curNode.right,2*currId+2));
            }

            ans = Math.max(ans,last - first + 1);
        }
        return ans;
    }
}