class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        
        int start = 0, sum = 0, min = nums.length+1;
        
        for(int i=0; i<nums.length; i++ ){
            
            sum += nums[i];
            
            while(sum >= target){
                min = Math.min(min, i - start +1);
                sum -=nums[start++];
                
            }
            
           
        }
        return min>nums.length? 0: min;
    }
}