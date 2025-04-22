class Solution {

    public int minHelp(String word1,String word2, int i, int j, Integer[][] dp){
        if(i<0) return j+1;
        if(j<0) return i+1;

        if(dp[i][j] != null) return dp[i][j];

        if(word1.charAt(i) == word2.charAt(j)) return dp[i][j] = minHelp(word1,word2,i-1,j-1,dp);

        return dp[i][j] = 1 + Math.min(minHelp(word1,word2,i-1,j-1,dp),
                Math.min(minHelp(word1,word2,i,j-1,dp),minHelp(word1,word2,i-1,j,dp)));

    }
    public int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        
        if(word1.equals(word2)) return 0;

        if(word1.length() == 0 || word2.length() == 0) 
            return Math.max(word1.length(), word2.length());

        Integer[][] dp = new Integer[n+1][m+1];
        
        return minHelp(word1,word2,n-1,m-1,dp);

    }
}