class Solution {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks,(a,b)->{
            // if(a[1]!=b[1]) return b[1]-a[1];
            // return a[0]-b[0];
            return (b[1]-b[0]) - (a[1]-a[0]);
        });
        int right = 0;
        int left = tasks[0][1];
        for(int [] task : tasks){
            left = Math.min(left,task[1]);
            right += task[1];
        }
        int ans = 0;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(isPossible(mid,tasks)){
                ans= mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return ans;
    }
    boolean isPossible(int energy,int [][] tasks){
        for(int [] task: tasks){
            if(energy<task[1]){
                return false;
            }else{
                energy = energy - task[0];
            }
        }
        return true;
    }
}