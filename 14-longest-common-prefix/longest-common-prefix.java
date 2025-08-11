class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        StringBuilder ans = new StringBuilder();
        int n = strs[0].length();
        for(int i=0;i<n;i++){
            if(strs[0].charAt(i) == strs[strs.length-1].charAt(i)) ans.append(strs[0].charAt(i));
            else break;
        }
        return ans.toString();
    }
}