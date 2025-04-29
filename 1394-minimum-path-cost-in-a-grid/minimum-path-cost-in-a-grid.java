class Solution {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int m = grid.length;
        int n  = grid[0].length;

        int cost = (int)1e9;
        Integer[][] dp = new Integer[m][n];

        for(int i=0;i<n;i++){
            cost = Math.min(cost,cost(grid, moveCost, 0, i, dp));
        }
        return cost;
    }

    private int cost(int[][] grid, int[][] moveCost, int row, int column,Integer[][] dp){
        int m = grid.length;
        int n  = grid[0].length;

        if(row == m-1) return grid[row][column];
        if(dp[row][column] != null) return dp[row][column];

        int cost = (int)1e9;
        int val = grid[row][column];

        for(int i = 0;i<n;i++){
            cost = Math.min(cost, val + moveCost[val][i] + cost(grid,moveCost,row+1,i,dp));
        }

        return dp[row][column] = cost;
    }   
}