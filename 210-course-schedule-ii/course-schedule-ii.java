class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        int [] deg = new int[numCourses];
        for(int[] edge : prerequisites){
            adj.get(edge[1]).add(edge[0]);
            deg[edge[0]]++;
        }
        Queue <Integer> q = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            if(deg[i]==0){
                q.offer(i);
            }
        }
        while(!q.isEmpty()){
            int node =q.poll();
            
            ans.add(node);
            for(int a:adj.get(node)){
                if(deg[a]==0) continue;
                deg[a]--;
                if(deg[a]==0){
                    q.offer(a);
                }
            }
        }
        int [] res = new int[numCourses];
        for(int i=0;i<deg.length;i++){
            if(deg[i]!=0)return new int[0];
        }
        for(int i=0;i<ans.size();i++){
            res[i] = ans.get(i);
        }
        return res;
    }
}