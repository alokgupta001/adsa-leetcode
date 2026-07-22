class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs , (a,b) -> a[1]-b[1]);
        int chains=1;
        int b = pairs[0][1];
        for(int i=1;i<pairs.length;i++){
            if(b<pairs[i][0]){
                b = pairs[i][1];
                chains++;
            }
        }
        return chains;
    }
}