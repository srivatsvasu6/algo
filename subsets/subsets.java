class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<>();
        
        if(nums==null || nums.length==0)
            return res;
       
             dfs(res,new ArrayList<>(), 0,nums);
        
        return res;
        
    }
    
    public void dfs( List<List<Integer>> res, List<Integer> curr, int start, int[] nums)    {   
    res.add(new ArrayList<>(curr));
    for(int i = start; i < nums.length; i++){
        curr.add(nums[i]);
        dfs(res, curr, i + 1, nums);
        curr.remove(curr.size() - 1);
    }
      
    }

}