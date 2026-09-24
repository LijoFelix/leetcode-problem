class Solution {
    List<String> ans;
    public List<String> generateParenthesis(int n) {
        ans=new ArrayList<>();
        generate(0,0,n,"");
        return ans;
    }
    private void generate(int ob,int cb,int n,String cur){
        if(cur.length()==n*2){
            ans.add(cur);
            return;
        }
        if(ob<n){
            generate(ob+1,cb,n,cur+"(");
        }
        if(cb<ob){
            generate(ob,cb+1,n,cur+")");
        }
    }
}