class Solution {

    public int calcTime(int i, List<Boolean> hasApple, List<List<Integer>> adj, boolean[] visited) {
        if(visited[i]) return 0;
        visited[i] =  true;

        int sum = 0;
        for(int edge : adj.get(i)){
            sum += calcTime(edge, hasApple,adj,visited);
        }

        if(i == 0) return sum;

        if(hasApple.get(i) || sum > 0) return (2 + sum);
        else return 0;
    }

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge: edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        return calcTime(0,hasApple,adj,visited);

    }
}