class Solution {
    public String reverseWords(String s) {
        
        
        s = s.trim();
        
       s =  s.replaceAll("[\\s]+"," ");
        
        char[] c = s.toCharArray();
         int i = 0, j = c.length -1;
        reverse(c, i, j);
        int prev = 0;
        for(i=0; i< c.length; i++){
            
            if(c[i] ==' '){
                reverse(c, prev, i-1);
                prev = i+1;
            }
            
            
        }
         reverse(c, prev, c.length-1);
        return new String(c);
        
        
    }
    
    public void reverse(char[] c, int i, int j){
      
        while(i<j){
            swap(c, i, j);
            i++;
            j--;
        }
    }
    
    public void swap(char[] arr, int i, int j){
        
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}