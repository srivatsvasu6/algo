class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        
        if(nums==null || nums.length ==0){
            return 0;
        }
        
        return ways(nums, 0, 0, target);
    }
    
    
    public int ways(int[] nums, int i, int sum,  int target){
        if(i==nums.length){
            return 0;
        }
        int ps = sum + nums[i];
        int ns = sum - nums[i];
        
        if(i == nums.length -1 ){
            if( ps == target && ns==target)
                return 2;
            else if( ps == target || ns==target)
                return 1;
            else
                return 0;
            
        }
                
            return ways(nums, i+1, ps, target) + ways(nums,  i+1, ns, target);

    }
    
}