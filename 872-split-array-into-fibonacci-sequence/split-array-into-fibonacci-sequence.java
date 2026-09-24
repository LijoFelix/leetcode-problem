class Solution {
    public List<Integer> splitIntoFibonacci(String num) {
        List<Integer> ans=new ArrayList<>();
        backtrack(num,0,ans);
        return ans;
    }
    private boolean backtrack(String s,int index,List<Integer> list){
        if(index==s.length()&&list.size()>=3){
            return true;
        }
        long cval=0;
        for(int i=index;i<s.length();i++){
            if(s.charAt(index)=='0'&&i>index){
                break;
            }
            cval=cval*10+(s.charAt(i)-'0');
            if(cval>Integer.MAX_VALUE){
                break;
            }
            int size=list.size();
            if(size>=2&&cval>(long)list.get(size-1)+list.get(size-2)){
                break;
            }
            if(size<2||cval==(long)list.get(size-1)+list.get(size-2)){
                list.add((int)cval);
                if(backtrack(s,i+1,list)){
                    return true;
                }
                list.remove(list.size()-1);
            }
        }
        return false;
    }
}