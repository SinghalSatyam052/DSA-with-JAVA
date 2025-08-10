class Solution {
    public int nextGreaterElement(int n) {
        char[] digit = Integer.toString(n).toCharArray();

        int i = digit.length-2;
        while(i>=0 && digit[i]  >= digit[i+1]) i--;

        if(i < 0) return -1;

        int j = digit.length-1;
        while(j>i && digit[j] <= digit[i]) j--;

        swap(digit,i,j);
        reverse(digit,i+1);

        long val = Long.parseLong(new String(digit));
        return (val>Integer.MAX_VALUE) ? -1 : (int) val;
    }

    private void swap(char[] digit, int i, int j) {
        char temp = digit[i];
        digit[i] = digit[j];
        digit[j] = temp;
    }
    private void reverse(char[] digit, int start) {
        int end = digit.length-1;
        while (start < end) {
            swap(digit, start, end);
            start++;
            end--;
        }
    }
}