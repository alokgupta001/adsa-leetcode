class Solution {
    class Pair{
        int node;
        long cost;
        Pair(int node,long cost){
            this.node = node;
            this.cost = cost;
        }
    }
    class Pairs{
        int node;
        long cost;
        int d;
        Pairs(int node,int d,long cost){
            this.node = node;
            this.d=d;
            this.cost = cost;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] flight : flights){
            int u = flight[0];
            int v = flight[1];
            int cost = flight[2];
            adj.get(u).add(new Pair(v,cost));
        }
        PriorityQueue<Pairs> pq = new PriorityQueue<>((a,b)->{
            if(a.cost==b.cost) return a.d-b.d;
            return Long.compare(a.cost,b.cost);
        });
        long [][] dis = new long[n][k+2];
        //int [] stops = new int[n];
        //Arrays.fill(stops,Integer.MAX_VALUE);
        //Arrays.fill(dis,Long.MAX_VALUE);
        for(long [] row : dis){
            Arrays.fill(row,Long.MAX_VALUE);
        }
        dis[src][0] = 0;
        //stops[src] =0;
        //int st =Integer.MAX_VALUE;
        //int ans = Integer.MAX_VALUE;
        pq.offer(new Pairs(src,0,0));
        while(!pq.isEmpty()){
            Pairs curr = pq.poll();
            int u = curr.node;
            int d = curr.d;
            long dist = curr.cost;
            //if(d>stops[u]) continue;
            if(u==dst){
                return (int)dist;
            }
            if(d-1>k) continue;
            for(Pair p : adj.get(u)){
                int v = p.node;
                int nd = d+1;
                long ndis = p.cost;
                if(nd-1<=k && dist+ndis<dis[v][nd] ){
                    
                    dis[v][nd] = dist + ndis;
                    pq.offer(new Pairs(v,nd,dis[v][nd]));
                }
                
            }
        }
        return -1;
    }
}