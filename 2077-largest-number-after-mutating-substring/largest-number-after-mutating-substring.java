class Solution {
    public String maximumNumber(String num, int[] change) {
        char[] arr = num.toCharArray();
        int n = arr.length;
        boolean mutated = false;
        for(int i=0;i<n;i++){
            int idx = (int)(arr[i]-'0');
            if(idx < change[idx]){
                arr[i] = (char)( change[idx]+'0');
                mutated = true;
            }else if(idx > change[idx] && mutated) break;
        }

        return new String(arr);
    }
}