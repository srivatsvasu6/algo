class Solution {
    public int minIncrementForUnique(int[] nums) {
        
        Arrays.sort(nums);
        int res = 0;
   
        int need = 0;
        
        for(int i=0; i<nums.length; i++){
          
            res += Math.max(need - nums[i] , 0);
            need = Math.max(nums[i], need) +1;
        }
        
        return res;
    }
}