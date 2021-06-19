class Solution {
    public boolean canPartition(int[] nums) {
        
        
        int sum =0;
        
        for(int i: nums){
            sum +=i;
        }
        
        if(sum%2 != 0 || nums.length<2 )
            return false;
        
        
       return  canPartition(nums, sum/2);
          
    }
    
     public boolean canPartition(int[] nums, int target) {
         
         
         boolean[] dp = new boolean[target +1];
         dp[0] = true;
         for(int i = 0; i<nums.length; i++){
             
             for(int j =target; j>= nums[i]; j-- ){
                 
                 dp[j] = dp[j] || dp[j - nums[i]];
             }
         }
         
         
         return dp[target];
         
     }
}