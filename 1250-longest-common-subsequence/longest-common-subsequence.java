class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length(), m = text2.length();
        int[] prev = new int[m + 1];  // Previous row

        for (int i = 1; i <= n; i++) {
            char c1 = text1.charAt(i - 1);
            int[] curr = new int[m + 1];  // Current row
            for (int j = 1; j <= m; j++) {
                char c2 = text2.charAt(j - 1);
                if (c1 == c2) {
                    curr[j] = prev[j - 1] + 1;
                } else {
                    curr[j] = Math.max(prev[j], curr[j - 1]);
                }
            }
            // Move current row to previous for the next iteration
            prev = curr;
        }

        return prev[m];  // Final answer is in prev[m] since curr was moved to prev
    }
}
