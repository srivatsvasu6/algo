class Solution {
    int res =0;
    public int countSubstrings(String s) {
     

        if(s== null || s.length() ==0){
         
           return 0;
        }
        
        for(int i = 0; i<s.length(); i++){
         
        isPalindrome(s, i, i);
        isPalindrome(s, i, i+1);
        }
        
        return res;
    }
    
    public void isPalindrome(String s, int l, int r){
        
        while (l >=0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            res++; r++; l--;
        }
    }
}