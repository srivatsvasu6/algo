class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        
        if(nums==null || nums.length ==0){
            return res;
        }
        Arrays.sort(nums);
        res.add(new ArrayList<>());
        
        int start =0, size = 0;
        
        for(int k =0; k< nums.length; k++ ){            
        
            start = (k > 0 && nums[k] == nums[k-1])? size: 0; 
            size = res.size();
            for(int i=start; i<size; i++){
               
                
                
                List<Integer> tmp = new ArrayList(res.get(i));
              
                tmp.add(nums[k]);
                
                res.add(new ArrayList<>(tmp));
               
            }
            
        }
        
        return res;
    }
}