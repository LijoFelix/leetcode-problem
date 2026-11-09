class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        int[] req = new int[k];
        PriorityQueue<int[]> busy = new PriorityQueue<>(
            Comparator.comparingInt(a -> a[0])
        );
        TreeSet<Integer> avl = new TreeSet<>();
        for(int i = 0; i < k; i++) {
            avl.add(i);
        }
        for(int i = 0; i < arrival.length; i++) {
            int arrtime = arrival[i];
            int endtime = arrtime+load[i];
            while(!busy.isEmpty() && busy.peek()[0] <= arrtime) {
                int[] complete = busy.poll();
                avl.add(complete[1]);
            }
            if(avl.isEmpty()) {
                continue;
            }
            Integer target = avl.ceiling(i%k);
            if(target == null) {
                target = avl.first();
            }
            req[target]++;
            busy.offer(new int[] {endtime, target});
            avl.remove(target);
        }
        int maxreq = 0;
        for(int c : req) {
            maxreq = Math.max(maxreq, c);
        }
        List<Integer> busiest = new ArrayList<>();
        for(int i = 0; i < k; i++) {
            if(req[i] == maxreq) {
                busiest.add(i);
            }
        }
        return busiest;
    }
}