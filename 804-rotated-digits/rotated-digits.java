class Solution {
    public int rotatedDigits(int n) {
        String s = Integer.toString(n);
        return solve(s,0,1,1,0);
    }
    int solve(String s,int idx,int tight,int lz,int mask){
        if(idx==s.length()){
            if(lz==1) return 0;
            if(((mask&(1<<2))!=0) || ((mask&(1<<5))!=0) || ((mask&(1<<6))!=0) || ((mask&(1<<9))!=0) ) return 1;
            return 0;
        }
        int ub = tight==1?s.charAt(idx)-'0':9;
        int cnt=0;
        for(int d=0;d<=ub;d++){
            if(d == 3 || d == 4 || d == 7) continue;
            int ntight = (tight==1 && d==ub)?1:0;
            int nlz = (lz==1 && d==0)?1:0;
            int newmask = mask|(1<<d);
            cnt+= solve(s,idx+1,ntight,nlz,newmask);
        }
        return cnt;
    }
}