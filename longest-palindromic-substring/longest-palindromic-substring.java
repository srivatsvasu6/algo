class Solution {
    public String longestPalindrome(String s) {
        
        
        if(s==null ||s.length()<1) return "";
        
        int start =0, end = 0;
        
        for(int i =0; i<s.length(); i++){
            
            int l1 = palLength(s, i, i);
            int l2 = palLength(s, i, i+1);
            
            int l = Math.max(l1, l2);
            
            if(l > end - start){
                start = i - (l - 1)/2;
                end = i + l/2;
            }
            
        }
        return s.substring(start, end+1);
        
        
    }
    
    public int palLength(String s, int i, int j){
        
        while( i>=0 && j<s.length() && s.charAt(i)== s.charAt(j)){
            i--;
            j++;
        }
        
        return j- i -1;
    }
}