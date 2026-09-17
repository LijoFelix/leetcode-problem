class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(nums);
        int n=nums.length;
        int total=1<<n;
        for(int i=0;i<total;i++){
            List<Integer> list=new ArrayList<>();
            boolean flag=false;
            for(int j=0;j<n;j++){
                if((i&(1<<j))!=0){
                    if(j>0&&nums[j]==nums[j-1]&&(i&(1<<(j-1)))==0){
                        flag=true;
                        break;
                    }
                    list.add(nums[j]);
                }
            }
            if(!flag){
                ans.add(list);
            }
        }
        return ans;

    }
}