class Solution {
    public int calculate(String s) {
        
        int res =0;
        int oper =0, sign =1;
        Stack<Integer> stack = new Stack<>();
        
        
        char[] ch = s.toCharArray();
        
        for( char c: ch ){
            
            
            if(c==' ' || Character.isDigit(c)){
                oper = (c==' ') ? oper : oper * 10 + ( c - '0');
                
            }else if(c == '(' ){
                
                stack.push(res);
                stack.push(sign);
                
                sign = 1;
                res = 0;
                
            } else if (c == ')') {
                
                res += sign * oper;
                
                res *= stack.pop();
                
                res += stack.pop();
                
                oper = 0;
                
            } 
            
            else{
                
                res += sign * oper;
                
                sign = c == '+'?1: -1;
                oper=0;
            }
            
            
            
        }
        
        return res + (oper *sign);
        
    }
}