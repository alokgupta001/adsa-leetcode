class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        k = k%(m*n);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<m;i++){
            ans.add(new ArrayList<>());
        }
        int currRow = 0;
        int currCol = 0;
        for(int i=m*n-k;i<m*n;i++){
            int nrow = i/n;
            int ncol = i%n;
            ans.get(currRow).add(grid[nrow][ncol]);
            currCol++;
            if(currCol==n){
                currCol = 0;
                currRow++;
            }
        }
        for(int i=0;i<m*n-k;i++){
            int nrow = i/n;
            int ncol = i%n;
            ans.get(currRow).add(grid[nrow][ncol]);
            currCol++;
            if(currCol==n){
                currCol = 0;
                currRow++;
            }
        }
        return ans;
    }
}