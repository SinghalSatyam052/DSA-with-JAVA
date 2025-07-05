class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        int[] prev = new int[m+1];

        for(int i=1;i<=n;i++){
            char c1 = word1.charAt(i-1);
            int[] curr = new int[m+1];

            for(int j=1;j<=m;j++){
                char c2 = word2.charAt(j-1);

                if(c1 == c2) curr[j] = prev[j-1] + 1;
                else curr[j] = Math.max(prev[j],curr[j-1]);
            }
            prev = curr;
        }

        int lcs = prev[m];

        return m + n - 2*lcs;

    }
}