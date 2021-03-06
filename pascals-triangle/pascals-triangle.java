class Solution {
    public List<List<Integer>> generate(int numRows) {
     List<List<Integer>> res = new ArrayList<>();
       res.add(Arrays.asList(1));
        
        for(int i= 1; i< numRows; i++){
            List<Integer> row = new ArrayList<>();
            List<Integer> prev = res.get(i - 1);
           
            row.add(1);
            
            for(int j = 1; j< i; j++){
                
                row.add(prev.get(j-1) + prev.get(j));
            }
            
            row.add(1);
            
            res.add(row);
            
        }
        return res;
        
    }
}