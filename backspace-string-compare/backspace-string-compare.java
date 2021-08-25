class Solution {
    public boolean backspaceCompare(String s, String t) {
        
        
        int l1 = s.length()-1, l2 = t.length()-1, skipS=0, skipT=0;
        
        while(l1 >=0 || l2>=0){
            
          while(l1 >=0 ){
              
              if(s.charAt(l1)== '#'){
                  skipS++;
                  l1--;
              }else if(skipS > 0){
                  skipS--; l1--;
              }else{
                  break;
              }
          }
            
             while(l2 >=0 ){
              
              if(t.charAt(l2)== '#'){
                  skipT++;
                  l2--;
              }else if(skipT > 0){
                  skipT--; l2--;
              }else{
                  break;
              }
          }
            
            
            
            if(l1 >=0 && l2 >=0  && s.charAt(l1) != t.charAt(l2)){
                return false;
            }
            
            if((l1 >=0 )!=( l2 >=0)){
                return false;
            }
            l1--; l2--;
        }
        return true;
    }
}