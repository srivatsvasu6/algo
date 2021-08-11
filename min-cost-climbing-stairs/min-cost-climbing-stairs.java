class Solution {
    public int minCostClimbingStairs(int[] cost) {
        
        int one = 0;
        int two = 0;
        
        for(int i = 2 ; i<=cost.length; i++){
            int tmp = one;
            one = Math.min(one+ cost[i-1] , two + cost[i-2]);
            two = tmp;
        }
        
        return one;
    }
}