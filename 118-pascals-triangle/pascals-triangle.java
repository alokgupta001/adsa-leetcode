class Solution {
    public List<List<Integer>> generate(int numRows) {
        int [][] ans = new int[numRows][numRows];
        for(int i=0;i<numRows;i++){
            ans[i][0] =1;
        }
        for(int i=1;i<numRows;i++){
            for(int j=1;j<numRows;j++){
                ans[i][j] = ans[i-1][j] + ans[i-1][j-1];
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<numRows;i++){
            List<Integer> temp = new ArrayList<>();
            for(int j=0;j<numRows;j++){
                if(ans[i][j]!=0) temp.add(ans[i][j]);
            }
            res.add(temp);
        }
        return res;
    }

}