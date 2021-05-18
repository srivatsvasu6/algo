class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>>  ls = new ArrayList<>();
        
        backtrack(ls,  target,  new ArrayList<>(), candidates, 0 );
        return ls;
    }
    
    public void backtrack(  List<List<Integer>>  ls , int target,List<Integer> temp, int[] candidates, int start ){
       if(target < 0) return;
        else if(target == 0) ls.add(new ArrayList<>(temp)); 
        else{
        
        for(int i=start; i<candidates.length; i++){
            
            temp.add(candidates[i]);
            backtrack(ls, target - candidates[i],  temp, candidates, i);
            temp.remove(temp.size() -1);
            
        }
        }
        
        
    }
}