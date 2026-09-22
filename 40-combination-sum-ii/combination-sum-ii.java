class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> cur=new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates,target,0,cur,ans);
        return ans;
    }
    private void backtrack(int[] candidates,int r,int st,List<Integer> cur,List<List<Integer>> ans){
        if(r==0){
            ans.add(new ArrayList<>(cur));
            return;
        }
        for(int i=st;i<candidates.length;i++){
            if(candidates[i]>r){
                break;
            }
            if(i>st&&candidates[i]==candidates[i-1]){
                continue;
            }
            cur.add(candidates[i]);
            backtrack(candidates,r-candidates[i],i+1,cur,ans);
            cur.remove(cur.size()-1);
        }
    }
}