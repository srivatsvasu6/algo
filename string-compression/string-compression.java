class Solution {
    public int compress(char[] chars) {
        
        if(chars == null || chars.length ==0)
            return 0;
        
        StringBuilder sb = new StringBuilder();
        char prev = '\n';
        int count = 0;
        
        for(int i=0; i<chars.length; i++){
            
            
            if(prev == chars[i]){
                count++;
                continue;
            }else{
                if(prev !='\n')
                   { 
                    sb.append(prev);
                    if(count > 1){
                        sb.append(count);
                    }
                }
                count = 1;
                prev = chars[i];    
   
            }
            
        }
        
        if(prev!='\n')
         sb.append(prev);
         if(count > 1){
             sb.append(count);
         }
        String s = sb.toString();
        
        int i =0;
        for(char c: s.toCharArray()){
            if(i< chars.length)
                chars[i++]= c;
        }
        
        return sb.length();
       
    }
}