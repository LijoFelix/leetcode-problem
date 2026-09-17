class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
    List<String> ans=new ArrayList<>();
    if(s==null||s.length()<10){
        return ans;
    }
    int[] map=new int[26];
    map['A'-'A']=0;
    map['C'-'A']=1;
    map['G'-'A']=2;
    map['T'-'A']=3;
    Set<Integer> seen=new HashSet<>();
    Set<Integer> added=new HashSet<>();
    int bmask=0;
    for(int i=0;i<9;i++){
        bmask=(bmask<<2)|map[s.charAt(i)-'A'];
    }
    int m=(1<<20)-1;
    for(int i=9;i<s.length();i++){
        bmask=((bmask<<2)|map[s.charAt(i)-'A'])&m;
        if(seen.contains(bmask)){
            if(!added.contains(bmask)){
                added.add(bmask);
                ans.add(s.substring(i-9,i+1));
            }
        }
        else{
            seen.add(bmask);
        }
    }
    return ans;
}
}