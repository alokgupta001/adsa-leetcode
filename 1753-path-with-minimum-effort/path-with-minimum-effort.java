class Solution {
    class Pair{
        int row,col;
        int dis;
        Pair(int row,int col,int dis){
            this.row=row;
            this.dis=dis;
            this.col=col;
        }
    }
    int []dir_r = {-1,1,0,0};
    int [] dir_c = {0,0,-1,1};
    public int minimumEffortPath(int[][] heights) {
        int m= heights.length;
        int n= heights[0].length;
        int [][] effort = new int[heights.length][heights[0].length];
        for(int [] row:effort){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        effort[0][0]=0;
        PriorityQueue<Pair> q = new PriorityQueue<>((a,b)->Long.compare(a.dis,b.dis));
        q.offer(new Pair(0,0,0));
        // int [][] parrent = new int[m][n];
        // for(int [] row:parrent){
        //     Arrays.fill(row,-1);
        // }
        while(!q.isEmpty()){
            Pair curr = q.poll();
            int row = curr.row;
            int col = curr.col;
            int dis =curr.dis;
            if(row==m-1 && col==n-1) return dis;
            if(dis>effort[row][col]) continue;
            for(int k=0;k<4;k++){
                int nrow = row+dir_r[k];
                int ncol = col+dir_c[k];
                if(nrow>=0 && nrow<m && ncol>=0 && ncol<n){
                    int ndis = Math.max(dis,Math.abs(heights[row][col]-heights[nrow][ncol]));
                    if(ndis<effort[nrow][ncol]){
                        effort[nrow][ncol]=ndis;
                        q.offer(new Pair(nrow,ncol,ndis));
                        //parrent[nrow][ncol]=k;
                    }
                }
            }
        }
        
        return 0;
    }
}