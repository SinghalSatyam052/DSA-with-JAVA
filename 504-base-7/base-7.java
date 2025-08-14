class Solution {
    public String convertToBase7(int num) {
        if(num == 0) return "0";
        if(num < 0) return "-"+convertToBase7(Math.abs(num));

        StringBuilder ans  = new StringBuilder();
        while(num > 0){
            ans.append(num%7);
            num/=7;
        }
        return ans.reverse().toString();
    }
}