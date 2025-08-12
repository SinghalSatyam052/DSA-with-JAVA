class Solution {
    public String maximumNumber(String num, int[] change) {
        char[] arr = num.toCharArray();
        int n = arr.length;
        for(int i=0;i<n;i++){
            if (arr[i] - '0' < change[arr[i] - '0']) {
                while(i<n && arr[i]-'0' <= change[(arr[i]-'0')]){
                    arr[i] = (char)(change[(arr[i]-'0')]+'0');
                    i++;
                }
                break;
            }
        }

        return new String(arr);
    }
}