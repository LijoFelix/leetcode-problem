class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> ans=new ArrayList<>();
        dfs(num,target,0,0,0,"",ans);
        return ans;
    }
    private void dfs(String num,int target,int idx,long eval,long tail,String path,List<String> ans){
        if(idx==num.length()){
            if(eval==target){
                ans.add(path);
            }
            return;
        }
        for(int i=idx;i<num.length();i++){
            if(i>idx&&num.charAt(idx)=='0'){
                break;
            }
            long cur=Long.parseLong(num.substring(idx,i+1));
            if(idx==0){
                dfs(num,target,i+1,cur,cur,path+cur,ans);
            }
            else{
                dfs(num,target,i+1,eval+cur,cur,path+"+"+cur,ans);
                dfs(num,target,i+1,eval-cur,-cur,path+"-"+cur,ans);
                dfs(num,target,i+1,eval-tail+(tail*cur),tail*cur,path+"*"+cur,ans);
            }
        }
    }
}