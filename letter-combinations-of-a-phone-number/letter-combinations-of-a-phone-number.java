class Solution {
    
   public static final List<String> NUM_LIST = Arrays.asList("","", "abc" ,"def","ghi", "jkl", "mno", "pqrs", "tuv", "wxyz");
    
    public List<String> letterCombinations(String digits) {
        
        if(digits==null || digits.length()==0){
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        
        backtrack(digits, 0, res, new StringBuilder());
        
        return res;
        
    }
    
    public void backtrack(String digits, int pos, List<String> res, StringBuilder sb){
        
        if(pos == digits.length()){
           
            res.add(sb.toString());
            
        }else{
            int digit = digits.charAt(pos) - '0';
            String letter = NUM_LIST.get(digit);
            
            for(char c: letter.toCharArray()){
                sb.append(c);
                
              backtrack(digits, 1+ pos, res, sb);
                
              sb.deleteCharAt(sb.length() - 1);
            }
            
            
        }
    }
}