class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
    
    List<Integer> res = new ArrayList<>();    
    for(int i=0; i<n; i++){
        int index = Math.abs(nums[i]) % n;
        
        if(nums[index] <0){
            
          res.add(Math.abs(nums[i]));
          
        }
        
          nums[index]  = - nums[index];
        
    }
        
        return res;
        
        
    }
}