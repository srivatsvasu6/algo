class Solution {
    public int removeDuplicates(int[] nums) {
     
      int d =1;
        if( nums.length<2){
            return 1;
        }
        
        for(int i=1; i<nums.length; i++){
            
            if(nums[i]!=nums[i-1]){
                nums[d++] = nums[i];
            }
        }
        
        return d;
        
    }
}