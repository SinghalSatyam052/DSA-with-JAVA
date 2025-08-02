class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();

        help(s,0,new ArrayList<String>(),ans);
        return ans;
    }

    public void help(String s, int idx, List<String> sub, List<List<String>> res){
        if(idx == s.length()) {
            res.add(new ArrayList<>(sub));
            return;
        }

        for(int i = idx;i<s.length();i++){
            if(isPal(s.substring(idx,i+1))) {
                sub.add(s.substring(idx,i+1));
                help(s,i+1,sub,res);
                sub.remove(sub.size()-1);
            }
        }
    }
    public boolean isPal(String s){
        int n = s.length();

        for(int i=0;i<=n/2;i++){
            if(s.charAt(i) != s.charAt(n-i-1)) return false;
        }
        
        return true;
    }
    
}