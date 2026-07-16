class Solution {
    int [] dir_i = {1,-1,0,0};
    int [] dir_j = {0,0,1,-1};
    int INF = (int)1e9;
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n =mat[0].length;
        Queue <int[]> q = new LinkedList<>();
        int [][] dist = new int [m][n];
        for(int [] row :dist){
            Arrays.fill(row,INF);
        }
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==0){
                    dist[i][j]=0;
                    q.offer(new int[]{i,j,0});
                }
            }
        }
        while(!q.isEmpty()){
            int [] curr = q.poll();
            int row= curr[0];
            int col = curr[1];
            int d=curr[2];
            for(int k=0;k<4;k++){
                int nRow = row+dir_i[k];
                int nCol = col+dir_j[k];
                int nd = d+1;
                if(nRow>=0 && nCol>=0 && nRow<m && nCol<n && mat[nRow][nCol]==1 && dist[nRow][nCol]>nd){
                    dist[nRow][nCol] = Math.min(nd,dist[nRow][nCol]);
                    q.offer(new int[]{nRow,nCol,nd});
                }
            }
        }
        
        return dist;
    }
}