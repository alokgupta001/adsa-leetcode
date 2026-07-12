class Solution {
    public int secondsBetweenTimes(String startTime, String endTime) {
        //int diffHrs = Integer.parseInt(endTime.substring(0,3))-Integer.parseInt(startTime.substring(0,3));
        int totalTimeStart = Integer.parseInt(startTime.substring(0,2))*60*60+Integer.parseInt(startTime.substring(3,5))*60+Integer.parseInt(startTime.substring(6,8));
        int totalTimeEnd = Integer.parseInt(endTime.substring(0,2))*60*60+Integer.parseInt(endTime.substring(3,5))*60+Integer.parseInt(endTime.substring(6,8));
        return totalTimeEnd-totalTimeStart;
    }
}