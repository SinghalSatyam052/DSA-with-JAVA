class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] words = text.split(" ");
        int cnt = 0;

        for(String word:words){
            boolean flag = true;
            for(int i=0;i<brokenLetters.length();i++){
                char c = brokenLetters.charAt(i);
                if(word.indexOf(c) != -1){
                    flag = false;
                    break;
                }
            }
            if(flag) cnt++;
        }
        return cnt;
    }
}