class Solution {
    static int[] dp;
    public int fib(int n) {
        dp = new int[n+1];

        if(n == 0 || n == 1) return n;

        dp[1] = 1;
        for(int i=2;i<=n;i++) dp[i] = dp[i-1] + dp[i-2];

        return dp[n];
    }
}