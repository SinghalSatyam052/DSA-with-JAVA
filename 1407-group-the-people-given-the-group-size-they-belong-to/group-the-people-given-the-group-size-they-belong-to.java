class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        int n = groupSizes.length;
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer,List<Integer>> map = new HashMap<>();

        for(int i=0;i<n;i++){
            map.computeIfAbsent(groupSizes[i], k->new ArrayList<>()).add(i);
        }

        for(int i:map.keySet()){
            List<Integer> group = new ArrayList<>();
            for(int j=0;j<map.get(i).size();j++){
                if(j % i == 0){
                    if(group.size() != 0){
                        ans.add(group);
                        group = new ArrayList<>();
                    } 
                }
                group.add(map.get(i).get(j));
            }
            if(group.size() != 0){
                ans.add(group);
            } 
        }

        return ans;


    }
}