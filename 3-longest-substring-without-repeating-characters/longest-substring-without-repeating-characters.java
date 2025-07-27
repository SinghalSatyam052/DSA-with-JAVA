class Solution {
    public int lengthOfLongestSubstring(String s) {
        String sub = "";
        HashMap<Character,Integer> hm = new HashMap<>();
        int maxLen = 0, currLen = 0, left = 0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(hm.containsKey(ch) && hm.get(ch) >= left){
                left = hm.get(ch) + 1;
            }
            hm.put(ch,i);
            currLen = i -left + 1;
            maxLen = Math.max(maxLen,currLen);
        }
        return maxLen;
    }
}