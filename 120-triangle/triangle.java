class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(m-1).size();
        Integer[][] dp = new Integer[m][n];
        return minCost(triangle,0,0,dp);
    }
    private int minCost(List<List<Integer>> triangle,int row, int col,Integer[][] dp){
        int m = triangle.size();

        if(row == m) return 0; // base case
        if(dp[row][col] != null) return dp[row][col]; // reocurring item

        int down = minCost(triangle, row+1,col,dp);
        int dia = minCost(triangle,row+1, col+1,dp);

        return dp[row][col] = triangle.get(row).get(col) + Math.min(down,dia);
    }
}