class Solution {
    public List<List<String>> partition(String s) {
        
        List<List<String>> res = new ArrayList<>();
        
        backtrack(res, s, new ArrayList<>(), 0);
        
        return res;
        
    }
    
    public void backtrack( List<List<String>> res,String s, List<String> temp, int start ){
      
        if(s.length() ==  start){
            res.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i=start; i<s.length(); i++){
            
            if(isPalindrome(s, start, i)){
                temp.add(s.substring(start, i+1));
                backtrack(res, s,temp, i+1);
                temp.remove(temp.size()-1);
                
            }
        }
        
        
    }
    
    public boolean isPalindrome(String s, int start, int end){
        
        while(start<end)
            if(s.charAt(start++) != s.charAt(end--)){
                return false;
            }
        return true;
        
    }
}