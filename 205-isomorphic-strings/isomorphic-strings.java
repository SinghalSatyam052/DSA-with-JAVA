class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, ArrayList<Integer>> mapST = new HashMap<>();
        Map<Character, ArrayList<Integer>> mapTS = new HashMap<>();

        for(int i=0;i<s.length();i++){
            char c1 = s.charAt(i);
            mapST.computeIfAbsent(c1, k -> new ArrayList<>()).add(i);
            char c2 = t.charAt(i);
            mapTS.computeIfAbsent(c2, k -> new ArrayList<>()).add(i);
        }

        for(int i=0;i<s.length();i++){
            ArrayList<Integer> m1 = mapST.get(s.charAt(i));
            ArrayList<Integer> m2 = mapTS.get(t.charAt(i));

            if(!m1.equals(m2)) return false;
        }

        return true;
    }
}