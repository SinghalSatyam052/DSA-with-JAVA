class Solution {
    public List<List<Integer>> adjListConv(int n,int[][] edge){

        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(int i=0;i<n;i++){
            for(int j =0;j<n;j++){
                if(edge[i][j] == 1 && i!=j){
                    adj.get(j).add(i);
                    adj.get(i).add(j);
                }
            }
        }

        return adj;
    }

    public void dfs(int node, boolean[] vis, List<List<Integer>> adj){
        vis[node] = true;
        for(int i : adj.get(node)) if(!vis[i]) dfs(i,vis,adj);
    }


    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        boolean[] vis = new boolean[n];
        List<List<Integer>> adj = adjListConv(n,isConnected);
        int cnt = 0;

        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(i,vis,adj);
                cnt++;
            }
        }

        return cnt;
    }
}
