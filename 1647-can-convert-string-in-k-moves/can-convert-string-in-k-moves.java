class Solution {
    public boolean canConvertString(String s, String t, int k) {

        if(s.length() != t.length()) return false;
        Set<Integer> set = new HashSet<>();
        int[] shift = new int[s.length()];
        Map<Integer,Integer> freq = new HashMap<>();

        for(int i=0;i<s.length();i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            int diff = c2-c1;
            diff = diff>=0?diff:26-Math.abs(diff);

            shift[i] = diff;
        }

        int maxFreq = 0;
        int maxFreqEle = 0;

        for(int num: shift){
            if(num == 0) continue;
            if(num > k) return false;
            freq.put(num,freq.getOrDefault(num,0)+1);

            if(freq.get(num) > maxFreq) {
                maxFreqEle = num;
                maxFreq = Math.max(freq.get(num),maxFreq);
            }
            else if(freq.get(num) == maxFreq){
                if(maxFreqEle < num) maxFreqEle = num;
            }
        }

        if(26 * (maxFreq-1) + maxFreqEle <= k) return true;

        return false;
    }
}