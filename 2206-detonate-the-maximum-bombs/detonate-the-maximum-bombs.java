class Solution {
    int max = 1;
    int [] size;
    int [] parent;
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        size = new int[n];
        parent = new int[n];

        for(int i=0;i<n;i++){
            parent[i]=i;
            size[i] = 1;
        }
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i=0;i<n;i++){
            int bomb1[] = bombs[i];
            for(int j = 0;j<n;j++){
                if(i==j) continue;
                int [] bomb2 = bombs[j];
                if(inRange(bomb1,bomb2)){
                    graph[i].add(j);
                }
            }
        }
        int ans = 1;

        
        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            ans = Math.max(ans, dfs(i, graph, visited));
        }
        return ans;
    }
    int dfs(int node, List<Integer>[] graph, boolean[] visited) {
        visited[node] = true;
        int count = 1;

        for (int next : graph[node]) {
            if (!visited[next]) {
                count += dfs(next, graph, visited);
            }
        }

        return count;
    }
    boolean inRange(int[] a, int[] b) {
        long dx = a[0] - b[0], dy = a[1] - b[1], r = a[2];
        return dx * dx + dy * dy <= r * r;
    }
    int find(int x){
        if(parent[x]==x) return x;
        return parent[x] = find(parent[x]);
    }
    boolean union(int x,int y){
        int a = find(x);
        int b = find(y);
        if(a==b) return false;
        if(size[a]<size[b]){
            int temp = a;
            a = b;
            b= temp;
        }
        size[a]+=size[b];
        parent[b]= a;
        max = Math.max(max,size[a]);
        return true;
    }
}