class Solution {
    int m,n;
    public int findCircleNum(int[][] isConnected) {
        //m = isConnected.length;
        n = isConnected.length;
        
        int cnt=0;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j =0;j<n;j++){
                if(isConnected[i][j]==1){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        int [] vis = new int [n];
        for(int i=0;i<n;i++){
            if(vis[i]==0){
                bfs(i,adj,vis);
                cnt++;
            }
        }
        return cnt;
    }
   
    int bfs(int i,List<List<Integer>> adj,int [] vis){
        vis[i]=1;
        Queue <Integer> q = new LinkedList<>();
        q.offer(i);
        int cities =0;
        while(!q.isEmpty()){
            int node = q.poll();
            
            for(int a:adj.get(node)){
                if(vis[a]==0){
                    cities++;
                    vis[a]=1;
                    q.offer(a);
                }
            }
        }
        return cities;
    }

}