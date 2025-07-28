class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        String ans = "";
        for(int i=0;i<n;i++){
            String oddSub = expandAroundCentre(s,i,i);
            String evenSub = expandAroundCentre(s,i,i+1);

            if(oddSub.length() > ans.length()) ans = oddSub;
            if(evenSub.length() > ans.length()) ans = evenSub;

        }
        return ans;
    }

    public String expandAroundCentre(String s,int left, int right){
        while(left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return s.substring(left+1,right);
    }
}
