class Solution {
 
    
    public boolean canJump(int[] nums) {
     
        int maxSoFar = nums[0], last = nums.length-1;
        
        for(int i = 1; i< last && maxSoFar >=i; i++ ){
            
            maxSoFar = Math.max(maxSoFar, i+ nums[i]);
        }
        
        return maxSoFar >= last;
        
    }
    
}