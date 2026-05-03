class Solution {
    public boolean isBipartite(int[][] graph) {
        int []vis= new int[graph.length];
        for(int i=0;i<graph.length;i++){
            if(vis[i]!=0) continue;
            if(bfs(i,graph,vis)){
                return false;
            }
        }
        return true;
    }
    boolean bfs(int i,int [][]graph ,int [] vis){
        vis[i]=1;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i,1});
        while(!q.isEmpty()){
            int node =q.peek()[0];
            int lvl = q.peek()[1];
            q.poll();
            for(int a:graph[node]){
                if(vis[a]==0){
                    vis[a]=lvl+1;
                    q.offer(new int[]{a,lvl+1});
                }else{
                    if((lvl+1)%2==0 && vis[a]%2==1){
                        return true;
                    }else if((lvl+1)%2==1 && vis[a]%2==0 ){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}