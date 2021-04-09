class Solution {
    public List<List<Integer>> permute(int[] nums) {
       List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(nums == null){
            return list;
        }
        
        dfs(new ArrayList<Integer>(),new boolean[nums.length], list, nums );
        
        return list;
        
        
    }
    
    public void dfs(List<Integer> paths , boolean[] used,   List<List<Integer>> list ,int[] nums ){
        
        if(paths.size() == used.length){
            list.add(new ArrayList<>(paths));
            return;
        }
        
        for(int i=0; i<nums.length; i++){
            
            if(used[i])
                continue;
            
            used[i]= true;
            paths.add(nums[i]);
            
            dfs(paths, used, list, nums);
            
            paths.remove(paths.size()-1);
            used[i] = false;
        }

    }
}