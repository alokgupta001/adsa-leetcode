class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        long nmass = (long) mass;
        for(int ast : asteroids){
            pq.offer((long) ast);
        }
        while(!pq.isEmpty()){
            long curr = pq.poll();
            if(curr<=nmass){
                nmass+=curr;
            }else{
                return false;
            }
        }
        return true;
    }
}