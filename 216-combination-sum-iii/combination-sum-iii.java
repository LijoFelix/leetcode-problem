class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> cur=new ArrayList<>();
        backtrack(k,n,1,cur,ans);
        return ans;
    }
    private void backtrack(int k,int r,int st,List<Integer> cur,List<List<Integer>> ans){
        if(cur.size()==k){
            if(r==0){
                ans.add(new ArrayList<>(cur));
            }
            return;
        }
        for(int i=st;i<=9;i++){
            if(i>r){
                break;
            }
            cur.add(i);
            backtrack(k,r-i,i+1,cur,ans);
            cur.remove(cur.size()-1);
        }
    }
}