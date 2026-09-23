class Solution {
    public int[] constructDistancedSequence(int n) {
        int len=2*n-1;
        int[] ans=new int[len];
        boolean[] used=new boolean[n+1];
        backtrack(0,ans,used,n);
        return ans;
    }
    private boolean backtrack(int i,int[] ans,boolean[] used,int n){
        while(i<ans.length&&ans[i]!=0){
            i++;
        }
        if(i==ans.length){
            return true;
        }
        for(int num=n;num>=1;num--){
            if(used[num]){
                continue;
            }
            if(num==1){
                ans[i]=1;
                used[1]=true;
                if(backtrack(i+1,ans,used,n)){
                    return true;
                }
                ans[i]=0;
                used[1]=false;
            }
            else{
                int sindex=i+num;
                if(sindex<ans.length&&ans[sindex]==0){
                    ans[i]=num;
                    ans[sindex]=num;
                    used[num]=true;
                    if(backtrack(i+1,ans,used,n)){
                        return true;
                    }
                    ans[i]=0;
                    ans[sindex]=0;
                    used[num]=false;
                }
            }
        }
        return false;
    }
}
