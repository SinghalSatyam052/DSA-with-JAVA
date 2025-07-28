class Solution {
    public boolean isPalindrome(int x) {
        if(x<0 || (x%10==0 && x!=0)){
            return false;
        }
        int ld = 0;
        int rev = 0;
        while(x>rev){
            ld = x%10;
            x = x/10;
            rev = rev*10 + ld;
        }
        return x==rev || x==rev/10;
    }
}