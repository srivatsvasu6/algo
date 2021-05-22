class Solution {
    public int maxProfit(int[] prices) {
        
        
     int maxP =0, max=0;
        for(int i=1; i<prices.length; i++){
            int profit = prices[i] - prices[i-1];
            maxP = Math.max(0, maxP+= profit);
            
          max = Math.max(max, maxP);
        }
        
        return max;
    }
}