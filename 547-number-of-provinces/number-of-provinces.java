class Solution {
    int component;
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int [] parent = new int[n];
        component =n;
        for(int i=0;i<parent.length;i++){
            parent[i]=i;
        }
        int [] rank = new int[n];
        List<int[]> edges =new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j) continue;
                if(isConnected[i][j]==1) edges.add(new int[]{i,j});
            }
        }
        for(int [] edge : edges){
            int x = edge[0];
            int y = edge[1];
            unionRank(x,y,parent,rank);
        }
        return component;
    }
    boolean unionRank(int x,int y,int []parent,int [] rank){
        int a = findParent(x,parent);
        int b = findParent(y,parent);
        if(a==b){
            return false;
        }
        if(rank[a]<rank[b]){
            parent[a] = b;
        }else if(rank[a]>rank[b]){
            parent[b]=a;
        }else{
            parent[a]=b;
            rank[b]++;
        }
        component--;
        return true;
    }
    int findParent(int x,int[]parent){
        if(parent[x]==x) return x;
        return parent[x] = findParent(parent[x],parent);
    }
}