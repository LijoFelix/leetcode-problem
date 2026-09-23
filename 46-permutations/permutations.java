class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> cur=new ArrayList<>();
        backtrack(ans,cur,nums);
        return ans;
    }
    private void backtrack(List<List<Integer>> ans,List<Integer> cur,int[] nums){
        if(cur.size()==nums.length){
            ans.add(new ArrayList<>(cur));
            return;
        }
        for(int num:nums){
            if(cur.contains(num)){
                continue;
            }
            cur.add(num);
            backtrack(ans,cur,nums);
            cur.remove(cur.size()-1);
        }
    }
}
    