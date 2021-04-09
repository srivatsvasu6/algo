class Solution {
    
    
    private static final List<String> LETTERS = IntStream.range(1,27)
        .mapToObj(Integer::toString)
        .collect(Collectors.toList());

    
    
    public int numDecodings(String s) {
        
       return dfs(0, new Integer[s.length()], s);
        
        
    }
    
    public int dfs(int i, Integer[] memo, String digits){
        
        if(i == digits.length()){
            return 1;
        }
        if(memo[i] !=null){
            return memo[i];
        }
        
        int ways = 0;
        
        for(String s : LETTERS){
            
            if(digits.substring(i).startsWith(s)){
                 ways +=  dfs( i+ s.length(), memo, digits);
                
            }
        }
        memo[i] = ways;
        return ways;
    }
    
    
}