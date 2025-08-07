class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(candidates);
        sum(candidates, 0, curr, ans, target);
        return ans;
    }
    public void sum(int[] candidates, int start, List<Integer> curr, List<List<Integer>> ans, int target){
        if(0 == target) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for(int i=start;i<candidates.length;i++){ 
            if(candidates[i] > target) return;
            curr.add(candidates[i]);
            sum(candidates, i, curr, ans, target - candidates[i]);
            curr.remove(curr.size()-1);
        }
    }
}