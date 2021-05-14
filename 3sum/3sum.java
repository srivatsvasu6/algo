class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int j=0, k=0, sum=0;
      List<List<Integer>> ls = new ArrayList<>();
        for(int i=0; i< nums.length -2; i++){
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            
            j= i+1;
            k= n -1;
            sum = 0 - nums[i];
            
            while(j < k){
                
      
                if( nums[j] + nums[k] == sum){
                    ls.add(Arrays.asList(nums[i], nums[j], nums[k]));
                       
                     while(j<k && nums[j] == nums[j+1]) j++;
                     while(j<k && nums[k] == nums[k-1]) k--;
                    
                        j++;
                        k--;
                     
                }else if(nums[j] + nums[k] < sum){
                    j++;
                }else{
                    k--;
                }
        
                 
            }
      
            
            
        }
        
        return ls;
        
    }
}