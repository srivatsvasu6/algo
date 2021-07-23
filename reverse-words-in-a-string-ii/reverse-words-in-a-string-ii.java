class Solution {
    public void reverseWords(char[] s) {
        int start = 0, end=0, n = s.length;
        rev(s, 0, n-1);

        while(start<n){
            
            
            while(end<n && s[end] !=' ') ++end;
            rev(s, start, end-1);
            start = end +1;
            ++end;
        }
        
       

    }
    
    public void rev(char[] a, int left, int right){
        
  
        while(left<right){
            char tmp = a[left];
            a[left++] = a[right];
            a[right--] = tmp;
        }
    }
}