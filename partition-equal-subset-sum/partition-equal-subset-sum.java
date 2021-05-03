class Solution {
    public boolean canPartition(int[] nums) {
        
    int sum = 0;
        
        for(int a: nums)
            sum +=a;
        
        
        if(sum % 2 !=0){
            return false;
        }

       int sub = sum/2;
        
        boolean[] dp = new boolean[sub+1];
        
        dp[0] = true;
        
      for (int num : nums) {
        for (int i = sub; i > 0; i--) {
            if (i >= num) {
                dp[i] = dp[i] || dp[i-num];
            }
        }
    }
        return dp[sub];
        
    }
}