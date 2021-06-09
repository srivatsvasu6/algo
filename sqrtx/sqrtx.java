class Solution {
    public int mySqrt(int x) {
        if(x<2) 
          return x;
        
        int i = 0, j = x/2;
        
        int mid;
        long num;
        
        
        while(i <= j){
            
            mid = i + (j-i)/2;
          
            num = (long) mid * mid;
            
            if(num > x ){
                j = mid - 1;
            }
            else if(num < x){
                i = mid +1;
            }else{
                return mid;
            }
            
        }
        
        return j;
        
    }
}