class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        
      int m= matrix.length;
        int n = matrix[0].length;
        
        int lo = 0, hi = m*n -1;
     
        while(lo <= hi){
            
            int mid = lo +(hi - lo)/2;
            
          int val =   matrix[mid/n][mid%n];
            
            if(val > target){
                hi = mid -1;
            }else if(val < target){
                lo = mid +1;
                
            }else{
                return true;
            }
        }
        
        return false;
    }
}