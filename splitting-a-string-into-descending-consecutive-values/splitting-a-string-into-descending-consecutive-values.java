class Solution {
    public boolean splitString(String s) {
 
       return splitString(s, null);
            
       
    }
     public boolean splitString(String s, Long prev) {
       long current =0;
        for(int i=0;i<s.length();i++) {
            current = current * 10 + s.charAt(i)-'0';
            if(prev == null) {
                if (splitString(s.substring(i+1), current)) 
                    return true;
            } else if(current == prev - 1 && (i==s.length()-1 || splitString(s.substring(i+1), current)))
                return true;
        }
        return false;
     }
    
}