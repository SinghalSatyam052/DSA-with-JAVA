class Solution {
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);

        int[] newCuts = new int[cuts.length+2];

        for(int i=0;i<cuts.length;i++) newCuts[i+1] = cuts[i];

        newCuts[cuts.length+1] = n;

        Integer[][] dp = new Integer[cuts.length+2][cuts.length+2];
        return cutHelp(0,cuts.length+1,newCuts,dp);
    }

    private int cutHelp(int start, int end, int[] cuts,Integer[][] dp){

        if(dp[start][end] != null) return dp[start][end];
        if (end - start <= 1) return 0;

        int minCost = (int)1e9;

        for(int i=start+1;i<end;i++){
            int cost = cuts[end] - cuts[start]  
                       + cutHelp(start,i,cuts,dp) + cutHelp(i,end,cuts,dp);

            minCost = Math.min(minCost,cost);
        }
        return dp[start][end] = minCost;
    }
}