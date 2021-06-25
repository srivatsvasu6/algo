class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        
        LinkedList<Integer> comb =new LinkedList<>();
        
         backtrack(0, n , k, comb, res);
        return res;
    }
    
    private void backtrack(int start, int remain, int k ,  LinkedList<Integer> comb ,  List<List<Integer>> res){
        
        if(comb.size() == k && remain ==0){
            res.add(new ArrayList<>(comb));
            return;
        }else if(remain < 0 || comb.size() ==k){
            return;
        }
        
        for(int i= start; i<9; ++i){
            
            comb.add(i+1);
            backtrack(i+1, remain - i -1 , k, comb, res);
            comb.removeLast();
        }
    }
}