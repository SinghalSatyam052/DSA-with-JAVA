class Solution {
    public int coinChange(int[] coins, int amount) {
        int c = coins.length;
        int[][] dp = new int[c][amount+1];

        Arrays.sort(coins);

        for(int i=1;i<= amount;i++){
            if(i%coins[0] == 0) dp[0][i] = i/coins[0];
            else dp[0][i] = (int)1e9;
        }

        for(int i=1;i<c;i++){
            for(int j=0;j<=amount;j++){
                int notTake = dp[i-1][j];
                int take = (int)1e9;

                if(j>=coins[i]) take = 1 + dp[i][j-coins[i]];
                dp[i][j] = Math.min(take,notTake);
            }
        }

        return dp[c-1][amount] >= (int)1e9 ? -1 : dp[c-1][amount];
    }
}