class Solution {
    public String addStrings(String num1, String num2) {
        
  StringBuilder sb = new StringBuilder();
        int m = num1.length() -1;
        int n = num2.length() -1;
   
        int s=0, c=0;
        
        while(m>=0 || n>= 0){
            
          int x1 = m>=0? num1.charAt(m) -'0' :0;
          int x2 = n>=0? num2.charAt(n) -'0' :0;
            
            s = (x1+x2+c)%10;
            c = (x1+x2+c)/10;
            
            sb.append(s);
            m--;n--;
            
        }
        
        if(c!=0){
            sb.append(c);
        }
        
        return sb.reverse().toString();
    }
}