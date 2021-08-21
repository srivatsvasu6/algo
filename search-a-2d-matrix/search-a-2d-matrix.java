class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int l =matrix.length, m= matrix[0].length, lo = 0, hi = l * m -1, mid = 0;
        
        while(lo <= hi){
            
            mid = lo +( hi - lo)/2;
           int val = matrix[mid/m][mid % m]; 
            if( val == target){
                return true;
            }else if(val > target){
               hi = mid -1; 
            }else{
               lo = mid +1;
            }
        }
        
        return false;
    }
}