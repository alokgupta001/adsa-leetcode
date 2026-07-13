class Solution {
    public boolean lemonadeChange(int[] bills) {
        //Arrays.sort(bills);
        int five = 0;
        int ten = 0;
        int twenty = 0;
        for(int bill : bills){
            if(bill==5){
                five++;
            }else if(bill==10){
                if(five>=1){
                    five--;
                    ten++;
                }else{
                    return false;
                }
            }else{
                if(ten>=1 && five>=1){
                    ten--;
                    five--;
                    twenty++;
                }else if(five>=3){
                    five-=3;
                    twenty++;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}