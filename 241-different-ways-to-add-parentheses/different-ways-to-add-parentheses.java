class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<expression.length();i++){
            char c=expression.charAt(i);
            if(c=='+'||c=='-'||c=='*'){
                List<Integer> left=diffWaysToCompute(expression.substring(0,i));
                List<Integer> right=diffWaysToCompute(expression.substring(i+1));
                for(int l:left){
                    for(int r:right){
                        if(c=='+'){
                            ans.add(l+r);
                        }
                        else if(c=='-'){
                            ans.add(l-r);
                        }
                        else if(c=='*'){
                            ans.add(l*r);
                        }
                    }
                }
            }
        }
        if(ans.isEmpty()){
            ans.add(Integer.parseInt(expression));
        }
        return ans;
    }
}