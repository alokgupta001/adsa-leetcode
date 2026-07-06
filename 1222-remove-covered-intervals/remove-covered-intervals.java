class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals , (a,b)->{
            if(a[0]!=b[0]) return a[0]-b[0];
            else return b[1] - a[1];
        });
        int cnt =0;
        int end = 0;
        for(int [] inter : intervals){
            if(inter[1]>end){
                cnt++;
                end = inter[1];
            }
        }
        return cnt;
    }
}