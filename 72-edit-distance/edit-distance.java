class Solution {
    public int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();

        Integer[][] dp = new Integer[l1+1][l2+1];

        if(word1.equals(word2)) return 0;
        if(l1 == 0 || l2 == 0) return Math.max(l1,l2);

        return help(word1,word2,l1-1,l2-1,dp);
    }

    public int help(String word1,String word2, int i, int j,Integer[][] dp){

        if(i<0) return j+1;
        if(j<0) return i+1;
        
        if(dp[i][j] != null) return dp[i][j];

        if(word1.charAt(i) == word2.charAt(j)) return dp[i][j] = help(word1,word2,i-1,j-1,dp);

        return dp[i][j] = 1 + Math.min(help(word1,word2,i-1,j-1,dp),
        Math.min(help(word1,word2,i,j-1,dp), help(word1,word2,i-1,j,dp)));
    }
}