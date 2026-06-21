class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int purchased = 0;
        for(int ice : costs){
            if(coins>=ice){
                purchased++;
                coins=coins-ice;
            }else{
                break;
            }
        }
        return purchased;
    }
}