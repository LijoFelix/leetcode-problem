class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> cur=new ArrayList<>();
        boolean[] track=new boolean[nums.length];
        backtrack(ans,cur,nums,track);
        return ans;
    }
    private void backtrack(List<List<Integer>> ans,List<Integer> cur,int[] nums,boolean[] track){
        if(cur.size()==nums.length&&!ans.contains(cur)){
            ans.add(new ArrayList<>(cur));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(track[i]){
                continue;
            }
            track[i]=true;
            cur.add(nums[i]);
            backtrack(ans,cur,nums,track);
            track[i]=false;
            cur.remove(cur.size()-1);
        }
    }
}