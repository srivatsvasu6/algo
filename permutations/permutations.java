class Solution {
    public List<List<Integer>> permute(int[] nums) {
       List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(nums == null){
            return list;
        }
        
        dfs(new ArrayList<Integer>(), list, nums );
        
        return list;
        
        
    }
    
    public void dfs(List<Integer> paths , List<List<Integer>> list ,int[] nums ){
        
        if(paths.size() == nums.length){
            list.add(new ArrayList<>(paths));
            return;
        }else{
        
            for(int i=0; i<nums.length; i++){
                
                if(paths.contains(nums[i]))
                    continue;

                paths.add(nums[i]);

                dfs(paths, list, nums);

                paths.remove(paths.size()-1);

            }
        }

    }
}