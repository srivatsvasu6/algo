class Solution {
    public int longestPalindrome(String s) {
        
        int[] arr = new int[128];
        
        for(char c: s.toCharArray()){
            arr[c]++;
        }
        
        int res = 0, val =0;
        boolean odd = false;
        
        for(int i=0; i<arr.length; i++){
           
            val = arr[i];
            
            if(val%2==0){
                res += val;
            }else{
                odd= true;
                res += val - 1;
            }
        }
        
        return odd ? res+1 : res;
    }
}