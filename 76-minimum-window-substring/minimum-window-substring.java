class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";
        
        Map<Character, Integer> tmap = new HashMap<>();
        for (char ch : t.toCharArray()) {
            tmap.put(ch, tmap.getOrDefault(ch, 0) + 1);
        }

        int left = 0, right = 0, cnt = t.length();
        int minLen = Integer.MAX_VALUE;
        String ans = "";

        while (right < s.length()) {
            char c = s.charAt(right);
            if (tmap.getOrDefault(c, 0) > 0) cnt--;
            tmap.put(c, tmap.getOrDefault(c, 0) - 1);
            right++;

            while (cnt == 0) {
                if (right - left < minLen) {
                    minLen = right - left;
                    ans = s.substring(left, right);
                }
                char c2 = s.charAt(left);
                tmap.put(c2, tmap.getOrDefault(c2, 0) + 1);
                if (tmap.get(c2) > 0) cnt++;
                left++;
            }
        }
        return ans;
    }
}
