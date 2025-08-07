class Solution {
    public String reverseVowels(String s) {
        String vowel = "AEIOUaeiou";
        char[] str = s.toCharArray();
        int n = s.length();

        int left = 0,right = n-1;

        while(left < right){
            while(left < right && vowel.indexOf(str[left]) == -1) left++;
            while(left < right && vowel.indexOf(str[right]) == -1) right--;
            
            char temp = str[left];
            str[left] = str[right];
            str[right] = temp;

            left++;
            right--;
        }

        String ans =  new String(str);
        return ans;
        
    }
}