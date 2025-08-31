/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();

        if(root == null) return null;

        queue.offer(root);

        while(!queue.isEmpty()){
            int n = queue.size();
            ArrayList<Node> level = new ArrayList<>();

            for(int i=0;i<n;i++){
                Node curr = queue.poll();

                level.add(curr);

                if(curr.left != null) queue.offer(curr.left);
                if(curr.right != null) queue.offer(curr.right);
            }

            for(int i=0;i<n-1;i++){
                level.get(i).next = level.get(i+1);
            }
            level.get(n-1).next = null;
        }
        return root;
    }
}