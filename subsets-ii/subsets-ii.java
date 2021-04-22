class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        
        if(nums==null || nums.length ==0)
            return new ArrayList<>();
        
        
        Arrays.sort(nums);
       List<List<Integer>> res = new ArrayList<>(); 
        res.add(new ArrayList<>());
        int start =0, size=0;
        for(int i=0; i<nums.length;i++){
     
                start = (i> 0 && nums[i] == nums[i-1]) ?size:0;
                size=  res.size();
                for(int j =start; j< size; j++){
                    
                    List<Integer> sub = new ArrayList<>(res.get(j));
                      
                    sub.add(nums[i]);
                    res.add(new ArrayList<>(sub));
                }
                
            
            
        }
        
        return res;
    }
}