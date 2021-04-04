class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        
        char min = '{' , res ='{';
        
        for(int i=0; i< letters.length; i++ ){
            
            char c = letters[i];
            if( c< res ){
                    res = c;
             }
            
            if(c > target){
             
                if( c< min ){
                    min = c;
             }
                
            }
            
            
            
        }
        return min!= '{' ? min: res ;
    }
}