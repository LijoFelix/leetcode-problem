class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> ans=new ArrayList<>();
        List<int[]> events=new ArrayList<>();
        for(int[] b:buildings){
            events.add(new int[]{b[0],-b[2]});
            events.add(new int[]{b[1],b[2]});
        }
        events.sort((a,b)->a[0]!=b[0]?Integer.compare(a[0],b[0]):Integer.compare(a[1],b[1]));
        PriorityQueue<Integer> maxheap=new PriorityQueue<>((a,b)->b-a);
        maxheap.add(0);
        int pmaxheight=0;
        for(int[] event:events){
            int x=event[0];
            int height=event[1];
            if(height<0){
                maxheap.add(-height);
            }
            else{
                maxheap.remove(height);
            }
            int cmaxheight=maxheap.peek();
            if(cmaxheight!=pmaxheight){
                ans.add(Arrays.asList(x,cmaxheight));
                pmaxheight=cmaxheight;
            }
        }
        return ans;
    }
}