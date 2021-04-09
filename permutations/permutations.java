class Solution {
    public List<List<Integer>> permute(int[] nums) {
       List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(nums == null){
            return list;
        }
        
        dfs(new ArrayList<Integer>(), 0, list, nums );
        
        return list;
        
        
    }
    
     private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] =  A[j];
        A[j] = temp;
    }
    
    public void dfs(List<Integer> paths ,int pos, List<List<Integer>> list ,int[] nums ){
        
        if(paths.size() == nums.length){
            list.add(new ArrayList<>(paths));
            return;
        }
        for(int i=pos; i<nums.length; i++){

            paths.add(nums[i]);
            swap(nums, i, pos);
            
            dfs(paths, pos+1, list, nums);
           
            paths.remove(paths.size()-1);
            swap(nums, i, pos);
        }
        

    }
}