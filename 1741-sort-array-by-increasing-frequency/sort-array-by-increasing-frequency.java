class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            if(map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }
            else{
                map.put(num,1);
            }
        }
        List<Integer> list=new ArrayList<>(map.keySet());
        Collections.sort(list,(a,b)->{
            if(map.get(a)==map.get(b)){
                return b-a;
            }
            else{
                return map.get(a)-map.get(b);
            }
        });
        int index=0;
        int[] ans=new int[nums.length];
        for(int num:list){
            for(int i=0;i<map.get(num);i++){
                ans[index++]=num;
            }
        }
        return ans;
    }
}