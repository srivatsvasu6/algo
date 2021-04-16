class Solution {
    

        
    public List<String> letterCombinations(String digits) {
        
        String[] map = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> res = new ArrayList<>();
        if(digits !=null && digits.length()> 0){
          dfs(new StringBuilder(), map, res, digits.toCharArray());
        }
       
        return res;
        
    }
    
    public void dfs(StringBuilder paths, String[] map, List<String> res, char[] digits ){
        
        if(paths.length() == digits.length){
            res.add(paths.toString());
            return;
        }
        
        int ch = Character.getNumericValue(digits[paths.length()]);
        
        for(char c : map[ch].toCharArray()){
            
            paths.append(c);
            
            dfs(paths,map, res, digits);
            
            paths.deleteCharAt(paths.length()-1);
        }
        
    }
}