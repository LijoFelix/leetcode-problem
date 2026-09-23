class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> cur=new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates,target,0,cur,ans);
        return ans;
    }
    private void backtrack(int[] candidates,int target,int start,List<Integer> cur,List<List<Integer>> ans){
        if(target==0){
            ans.add(new ArrayList<>(cur));
            return;
        }
        for(int i=start;i<candidates.length;i++){
            if(candidates[i]>target){
                return;
            }
            cur.add(candidates[i]);
            backtrack(candidates,target-candidates[i],i,cur,ans);
            cur.remove(cur.size()-1);
        }
    }
}