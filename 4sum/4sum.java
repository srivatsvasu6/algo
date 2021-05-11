class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        List<List<Integer>> res = new ArrayList<>();
        
        int l = 0, n = nums.length,h = n -1, sum = 0;
  
        Arrays.sort(nums);
        
        for(int i=0; i<n-2; i++){
            
            for(int j = i+1; j< n-1; j++){
            
                l = j+1;
                h = n-1;
                
                int target2 = target - nums[i] - nums[j];
                
                while(l<h){
                    sum =  nums[l] + nums[h];
                    
                    if(sum < target2){
                        l++;
                    }else  if(sum > target2){
                      
                        h--;
                    }else{
                        
                    res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[h]));
                        
                    while(++l<=h && nums[l-1]==nums[l]) continue; 
                    while( --h>=l && nums[h]==nums[h+1]) continue; 
                        
                    }
                    
                }
                while(j < n-1 && nums[j+1]== nums[j]) j++;
         
                
            }
              while(i<n-1 && nums[i+1]== nums[i]) i++;
        }
        
        return res;
        
    }
}