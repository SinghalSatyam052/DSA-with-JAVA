class Solution {
    public String reverseWords(String s) {
        s.trim();
        String[] arr = s.split("\\s+");
        int n  = arr.length;
        for(int i=0;i<n/2;i++){
            String temp = arr[i];
            arr[i] = arr[n-i-1];
            arr[n-i-1] = temp;
        }
        StringBuilder ans = new StringBuilder();
        for(String str:arr) {
            ans.append(str);
            ans.append(" ");
        }
        return ans.toString().trim();
    }
}