class Solution {
    public String longestDiverseString(int a, int b, int c) {
        
        
        int A=0, B=0, C=0;
        
        StringBuilder sb = new StringBuilder();
        
  int size = a+b+c;
        
        for(int i=0; i<size; i++){
            
           if((A != 2 && a>=b && a>=c)||(B==2 && a>0) || (C==2 && a>0) ){
               
               sb.append("a");
               a--;
               A++;
               B=0;
               C=0;
           }
            else  if((B != 2 && b>=a&& b>=c)||(A==2 && b>0) || (C==2 && b>0) ){
               
               sb.append("b");
               b--;
               B++;
               A=0;
               C=0;
           }
            
            else  if((C != 2 && c>=a&& c>=b)||(A==2 && c>0) || (B==2 && c>0) ){
               
               sb.append("c");
               c--;
               C++;
               A=0;
               B=0;
           }
            
            
        }
        
        return sb.toString();
        
    }
}