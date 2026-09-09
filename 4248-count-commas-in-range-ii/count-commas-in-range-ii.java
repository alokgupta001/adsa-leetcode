class Solution {
    public long countCommas(long n) {
        //String s = Long.toString();
        if(n<1000) return 0;
        long cnt=0;
        long max = 999999L;
        long min = 1000L;
        if(n<=max){
            cnt = cnt+(n-min+1)*1;
            return cnt;
        }else{
            cnt=cnt+(max-min+1)*1;
        }
        max = 999999999L;
        min = 1000000L;
        if(n<max){
            long rem = n-min+1;
            cnt =cnt+(rem*2);
            return cnt;
        }else{
            cnt = cnt +(max-min+1)*2;
        }
        max = 999999999999L;
        min = 1000000000L;
        if(n<=max){
            long rem = n-min+1;
            cnt=cnt+(rem*3);
            return cnt;
        }else{
            cnt=cnt+(max-min+1)*3;
        }
        max = 999999999999999L;
        min = 1000000000000L;
        if(n<=max){
            long rem = n-min+1;
            cnt =cnt+(rem*4);
            return cnt;
        }else{
            cnt=cnt+(max-min+1)*4;
        }
        if(n== ((long)1e15)){
            cnt = cnt +5;
        }
        return cnt;
    }
}