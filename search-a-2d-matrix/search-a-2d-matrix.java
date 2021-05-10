class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        
        int start = 0, end = m*n -1, mid =0;

        
        while(start <= end){
            
            mid = start + (end - start)/2;
            
            int key = matrix[mid/n][mid%n];
            if(key==target){
                return true;
            }else if(key < target){
               start = mid +1;
            }else{
               end = mid -1;
            }
            
            
        }
        
        return false;
        
    }
}