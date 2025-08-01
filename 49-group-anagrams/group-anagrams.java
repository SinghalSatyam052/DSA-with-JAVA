class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,ArrayList<String>> keys = new HashMap<>();

        for(String s : strs){
            int[] freq = new int[26];

            for(int i=0;i<s.length();i++){
                int idx = s.charAt(i)-'a';
                freq[idx] += 1;
            }

            String key = Arrays.toString(freq);

            keys.computeIfAbsent(key,k->new ArrayList<>()).add(s);

        }

        List<List<String>> ans = new ArrayList<>();

        for(List<String> value : keys.values()) ans.add(value);

        return ans;
    }
}