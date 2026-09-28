class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n=profits.length;
        int[][] projects=new int[n][2];
        for(int i=0;i<n;i++){
            projects[i][0]=capital[i];
            projects[i][1]=profits[i];
        }   
        Arrays.sort(projects,(a,b)->Integer.compare(a[0],b[0]));
        PriorityQueue<Integer> max=new PriorityQueue<>(Collections.reverseOrder());
        int ptr=0;
        for(int i=0;i<k;i++){
            while(ptr<n&&projects[ptr][0]<=w){
                max.offer(projects[ptr][1]);
                ptr++;
            }
            if(max.isEmpty()){
                break;
            }
            w+=max.poll();
        }
        return w;
    }
}