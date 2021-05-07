class Solution {
    public int maxSubArray(int[] nums) {
        int start = 0, i=0, end = nums.length, sum=0, max=Integer.MIN_VALUE;
        
        while(i<end){
            
            sum += nums[i++];
            max = Math.max(max,sum);
             
            
            if(sum < 0){
                sum = 0;
               
            }
            
        
        }
        
        return max;
    }
}