class Solution {
    public String removeKdigits(String num, int k) {
        StringBuilder ans=new StringBuilder();
        for(char c:num.toCharArray()){
            while(k>0&&ans.length()>0&&ans.charAt(ans.length()-1)>c){
                ans.deleteCharAt(ans.length()-1);
                k--;
            }
            ans.append(c);
        }
        while(k>0){
            ans.deleteCharAt(ans.length()-1);
            k--;
        }
        int start=0;
        while(start<ans.length()&&ans.charAt(start)=='0'){
            start++;
        }
        String answer=ans.substring(start);
        return answer.isEmpty()?"0":answer;
    }
}