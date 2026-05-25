class Solution {
    Boolean [] dp;
    public boolean canReach(String s, int minJump, int maxJump) {
        char [] s1 = s.toCharArray();
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[s1.length];
        q.offer(0);
        vis[0]=true;
        int last= 0;
        while(!q.isEmpty()){
            int node = q.poll();
            if(node==s1.length-1) return true;
            int start = Math.max(node+minJump,last+1);
            int end = Math.min(node+maxJump,s1.length-1);
            for(int j=start;j<=end;j++){
                if(j>=s1.length) break;  
                if(s1[j]=='0' && !vis[j]){
                    vis[j] = true;
                    q.offer(j);
                }
            }
            last = end;
        }
        return false;
    }
}