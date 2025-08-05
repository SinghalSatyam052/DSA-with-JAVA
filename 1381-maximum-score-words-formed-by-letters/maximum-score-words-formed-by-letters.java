class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int n = words.length;
        
        // Frequency of available letters
        int[] letterFreq = new int[26];
        for (char ch : letters) {
            letterFreq[ch - 'a']++;
        }

        // Precompute frequency and score of each word
        int[][] wordFreq = new int[n][26];
        int[] wordScore = new int[n];
        
        for (int i = 0; i < n; i++) {
            for (char ch : words[i].toCharArray()) {
                int idx = ch - 'a';
                wordFreq[i][idx]++;
                wordScore[i] += score[idx];
            }
        }

        int maxScore = 0;

        // Try every subset of words using bitmasking
        for (int mask = 0; mask < (1 << n); mask++) {
            int[] freq = new int[26];
            int totalScore = 0;
            boolean valid = true;

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) { // word i is included
                    for (int j = 0; j < 26; j++) {
                        freq[j] += wordFreq[i][j];
                        if (freq[j] > letterFreq[j]) {
                            valid = false;
                        }
                    }
                    totalScore += wordScore[i];
                }
            }

            if (valid) {
                maxScore = Math.max(maxScore, totalScore);
            }
        }

        return maxScore;
    }
}
