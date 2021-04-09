class Solution {
    
     private static final Map<Character, char[]> KEYBOARD = new HashMap<>();
    static {
        KEYBOARD.put('2', "abc".toCharArray());
        KEYBOARD.put('3', "def".toCharArray());
        KEYBOARD.put('4', "ghi".toCharArray());
        KEYBOARD.put('5', "jkl".toCharArray());
        KEYBOARD.put('6', "mno".toCharArray());
        KEYBOARD.put('7', "pqrs".toCharArray());
        KEYBOARD.put('8', "tuv".toCharArray());
        KEYBOARD.put('9', "wxyz".toCharArray());
    }
        
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits !=null && digits.length()> 0){
          dfs(new StringBuilder(), res, digits.toCharArray());
        }
       
        return res;
        
    }
    
    public void dfs(StringBuilder paths,List<String> res, char[] digits ){
        
        if(paths.length() == digits.length){
            res.add(paths.toString());
            return;
        }
        
        char ch = digits[paths.length()];
        
        for(char c : KEYBOARD.get(ch)){
            
            paths.append(c);
            
            dfs(paths, res, digits);
            
            paths.deleteCharAt(paths.length()-1);
        }
        
    }
}