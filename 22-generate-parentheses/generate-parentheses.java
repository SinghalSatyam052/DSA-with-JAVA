class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>();
        generate(0,0,n,"",ans);
        return ans;
    }

    public void generate(int open,int bracExhausted, int n,String curr,List<String> ans){
        
        if(bracExhausted == n ){
            ans.add(curr + ")".repeat(open));
            return;
        }

        generate(open+1, bracExhausted+1, n, curr+"(", ans);
        if(open!=0) generate(open-1, bracExhausted, n, curr+")", ans);


    }
}