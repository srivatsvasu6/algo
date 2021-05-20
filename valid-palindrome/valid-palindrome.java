class Solution {
    public boolean isPalindrome(String s) {
        
        int i=0, j=s.length()-1;
        s = s.toUpperCase();
        
        while(i<=j){
            
            char left = s.charAt(i);
             char right = s.charAt(j);
            if(!Character.isLetterOrDigit(left)){
                 i++;
                continue;
                
            }
          if(!Character.isLetterOrDigit(right)){
                
                j--;
                continue;
            }
          if(left !=right){
              return false;
          }
            i++;
            j--;
        }
        
        return true;
    }
}