class Solution {
    public List<String> removeInvalidParentheses(String s) {
        int l=0,r=0;
        for(char c:s.toCharArray()){
            if(c=='('){
                l++;
            }
            else if(c==')'){
                if(l>0){
                    l--;
                }
                else{
                    r++;
                }
            }
        }
        Set<String> ans=new HashSet<>();
        dfs(s,0,0,l,r,new StringBuilder(),ans);
        return new ArrayList<>(ans);
    }
    private void dfs(String s,int i,int open,int l,int r,StringBuilder sb,Set<String> ans){
        if(i==s.length()){
            if(l==0&&r==0&&open==0){
                ans.add(sb.toString());
            }
            return;
        }
        char c=s.charAt(i);
        int len=sb.length();
        if(c=='('&&l>0){
            dfs(s,i+1,open,l-1,r,sb,ans);
        }
        if(c==')'&&r>0){
            dfs(s,i+1,open,l,r-1,sb,ans);
        }
        sb.append(c);
        if(c!='('&&c!=')'){
            dfs(s,i+1,open,l,r,sb,ans);
        }
        else if(c=='('){
            dfs(s,i+1,open+1,l,r,sb,ans);
        }
        else if(open>0){
            dfs(s,i+1,open-1,l,r,sb,ans);
        }
        sb.setLength(len);
    }
}