class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int [] month = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int aliceAriveMonth = Integer.parseInt(arriveAlice.substring(0,2));
        int aliceArriveDay = Integer.parseInt(arriveAlice.substring(3,5));
        for(int i=0;i<aliceAriveMonth-1;i++){
            aliceArriveDay+=month[i];
        }
        int bobAriveMonth = Integer.parseInt(arriveBob.substring(0,2));
        int bobArriveDay = Integer.parseInt(arriveBob.substring(3,5));
        for(int i=0;i<bobAriveMonth-1;i++){
            bobArriveDay+=month[i];
        }
        int aliceLeaveMonth = Integer.parseInt(leaveAlice.substring(0,2));
        int aliceLeaveDay = Integer.parseInt(leaveAlice.substring(3,5));
        for(int i=0;i<aliceLeaveMonth-1;i++){
            aliceLeaveDay+=month[i];
        }
        int bobLeaveMonth = Integer.parseInt(leaveBob.substring(0,2));
        int bobLeaveDay = Integer.parseInt(leaveBob.substring(3,5));
        for(int i=0;i<bobLeaveMonth-1;i++){
            bobLeaveDay+=month[i];
        }
        int start = Math.max(aliceArriveDay,bobArriveDay);
        int end = Math.min(aliceLeaveDay,bobLeaveDay);
        if(end<start) return 0;
        return end-start+1;
    }
}