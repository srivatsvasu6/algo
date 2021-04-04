class Solution {
    public int[] sortedSquares(int[] A) {
      
        int n = A.length;
        int[] res = new int[n];
        
     
        
        
        int i=0, j = n-1, k = j;
        while(i <= j){
            
            if(Math.abs(A[j]) > Math.abs(A[i])){
                
                res[k--] = A[j] * A[j];
                j--;
            }else{
                res[k--] = A[i] * A[i];
                i++;
            }
            
        }
        return res;
        
        
    }
}