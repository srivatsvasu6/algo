class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        
        int size = nums.length, ws = 1, start =0, res = 0, prod = 1; 
            if (k <= 1) return 0;
            
            for(int end=0; end<nums.length; end++){
                
                prod *= nums[end];
                               
               
                while(prod >= k)  prod /= nums[start++];
            
                res += end - start +1;
            }
           
        
        return res;
        
 
    }
}