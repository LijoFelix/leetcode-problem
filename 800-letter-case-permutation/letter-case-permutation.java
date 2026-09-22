class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> ans=new ArrayList<>();
        backtrack(s.toCharArray(),0,ans);
        return ans;
    }
    private void backtrack(char[] ch,int i,List<String> ans){
        if(i==ch.length){
            ans.add(new String(ch));
            return;
        }
        if(Character.isLetter(ch[i])){
            ch[i]=Character.toLowerCase(ch[i]);
            backtrack(ch,i+1,ans);
            ch[i]=Character.toUpperCase(ch[i]);
            backtrack(ch,i+1,ans);
        }
        else{
            backtrack(ch,i+1,ans);
        }
    }
}