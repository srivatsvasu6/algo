class Solution {
    
    public static final int I = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
       
        if(amount<1)
            return 0;
        
      int[] dp = new int[amount+1];
      Arrays.fill(dp, I); 
      dp[0]=0;
       int numCoins =0;
       for(int den : coins){
           
           for(int amt = 0; amt<=amount; amt++){
               
               if(den <= amt){
                   
                   if(dp[amt-den]==I)
                       numCoins = I;
                   else
                       numCoins = dp[amt-den]+1;
                   
                   dp[amt] = Math.min(dp[amt], numCoins);
                   
               }
               
           }
           
       } 
        
        return dp[amount]==I? -1: dp[amount];
        
    }
}