class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>>  res = new ArrayList<>();
        
        backtrack(candidates, 0, target, new LinkedList<>(), res);
        return res;
    }
    
    private void backtrack(int[] candidates, int start, int remain,LinkedList<Integer> comb, List<List<Integer>>  res  ){
        
        
        if(remain == 0){
          res.add(new ArrayList<>(comb));
            return;
        }else if(remain < 0){
            return;
        } else{
            
            for(int i= start; i< candidates.length; i++){
                
                comb.add(candidates[i]);
                backtrack(candidates, i, remain-candidates[i] , comb, res);
                comb.removeLast();  
                
            }
            
            
        }
    }
}