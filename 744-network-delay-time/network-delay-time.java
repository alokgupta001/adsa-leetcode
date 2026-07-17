class Solution {
    class Pair{
        int node;
        long w;
        Pair(int node,long w){
            this.node = node;
            this.w = w;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int [] edge : times){
            adj.get(edge[0]).add(new Pair(edge[1],edge[2]));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Long.compare(b.w,a.w));
        long [] dist = new long[n+1];
        Arrays.fill(dist,Long.MAX_VALUE);
        dist[k]=0L;
        pq.offer(new Pair(k,0L));
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int node = curr.node;
            long w = curr.w;
            if(w>dist[node]) continue;
            for(Pair neigh : adj.get(node)){
                int child = neigh.node;
                long cost = neigh.w;
                if(dist[child]>dist[node]+cost){
                    dist[child] = dist[node]+cost;
                    pq.offer(new Pair(child,dist[child]));
                }
            }
        }
        long max = 0;
        for(int i=1;i<=n;i++){
            long cost = dist[i];
            max = Math.max(max,cost);
        }
        return max==Long.MAX_VALUE?-1:(int)max;
    }
}