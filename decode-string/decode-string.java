class Solution {
    public String decodeString(String s) {
       
    Deque<Integer> countStack = new ArrayDeque<>();
    Deque<StringBuilder> strStack = new ArrayDeque<>();
    int k = 0;
    StringBuilder cur = new StringBuilder();
   for (char ch : s.toCharArray()) {
        
        if(Character.isDigit(ch)){
             k = k * 10 + ch - '0';
        }else if(ch == '['){
            
            countStack.push(k);
            strStack.push(cur);
            cur = new StringBuilder();
            k =0;
        }else if(ch == ']'){
         
           StringBuilder tmp = cur;
            cur = strStack.pop();
            for(k = countStack.pop(); k >0; k--){
                cur.append(tmp);
            }
            
            
        }else 
            cur.append(ch);
    }
        
    return cur.toString();
    }
    
   
}