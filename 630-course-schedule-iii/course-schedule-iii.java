class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses,(a,b)->Integer.compare(a[1],b[1]));
        PriorityQueue<Integer> maxheap=new PriorityQueue<>((a,b)->Integer.compare(b,a));
        int ctime=0;
        for(int[] course:courses){
            int duration=course[0],lastday=course[1];
            ctime+=duration;
            maxheap.offer(duration);
            if(ctime>lastday){
                ctime-=maxheap.poll();
            }
        }
        return maxheap.size();
    }
}