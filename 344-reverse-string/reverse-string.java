class Solution {
    public void reverseString(char[] s) {
        for(int i=0;i<s.length/2;i++){
            int start = i,end = s.length-1-i;
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
}