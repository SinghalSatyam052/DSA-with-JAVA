class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;

        int total = 0;
        for(int i:nums) total += i;

        Integer[][] dp = new Integer[n][n];

        int player1 = score(0,n-1,nums,dp);

        if(player1*2 >= total) return true;
        return false;
    }
    public int score(int i, int j, int[] nums, Integer[][] dp){
        if(i > j) return 0;
        if(dp[i][j] != null) return dp[i][j];

        int takeFirst = nums[i] + Math.min(score(i+2,j,nums,dp), score(i+1,j-1,nums,dp));
        int takeLast = nums[j] + Math.min(score(i,j-2,nums,dp), score(i+1,j-1,nums,dp));

        return dp[i][j] = Math.max(takeFirst, takeLast);
    }
}