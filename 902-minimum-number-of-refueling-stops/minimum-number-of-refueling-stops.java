class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        
        
        int currentRP=0;
        int jumps=0;
        int i=0;
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->(b-a));

        pq.add(startFuel);
        while(pq.size()>0 && currentRP<target)
        {
            int fuel=pq.poll();
            currentRP=currentRP+fuel;
            jumps++;
            while(i<stations.length && stations[i][0]<=currentRP)
            {
                pq.add(stations[i][1]);
                i++;
            }
        }
    

        return currentRP<target ? -1 :jumps-1;

    }
}