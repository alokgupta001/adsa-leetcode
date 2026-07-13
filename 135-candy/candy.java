class Solution {
    public int candy(int[] ratings) {
        int left = ratings.length;
        if(left==1) return 1;
        int [] extra = new int[left];
        for(int i=1;i<ratings.length;i++){
            if(ratings[i]>ratings[i-1]){
                extra[i] = extra[i-1]+1;
            }
        }
        for(int i=extra.length-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                extra[i] = Math.max(extra[i+1]+1,extra[i]);
            }
            
        }
        for(int i=0;i<extra.length;i++){
            left = left+extra[i];
        }
        return left;
    }
}