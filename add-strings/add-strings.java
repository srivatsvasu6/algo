class Solution {
    public String addStrings(String num1, String num2) {
        
        StringBuilder sb = new StringBuilder();
        int m = num1.length() -1;
        
        int n = num2.length() -1;
        
        int carry = 0;
        
        while(m>=0 || n>=0){
            
            int a = m>=0? num1.charAt(m) -'0' :0;
            int b = n>=0? num2.charAt(n) -'0' :0;
            
            int val = a + b + carry;
            carry = val /10;
            
            sb.append(val % 10);
            m--;
            n--;
        }
        
        if(carry!=0)
            sb.append(carry);
        
        return sb.reverse().toString();
    }
}