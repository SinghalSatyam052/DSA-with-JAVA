class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        Integer[][] dp = new Integer[m][n];

        return path(obstacleGrid, m-1,n-1,dp);
    }

    private int path(int[][] obs, int m, int n,Integer[][] dp){
        if(m == 0 && n == 0 && obs[0][0] == 0) return 1;
        if(m<0 || n<0) return 0;

        if(dp[m][n] != null) return dp[m][n];

        if(obs[m][n] == 1) return 0;

        int up = path(obs,m,n-1,dp);
        int left = path(obs,m-1,n,dp);

        return dp[m][n] = up + left;
    }
}