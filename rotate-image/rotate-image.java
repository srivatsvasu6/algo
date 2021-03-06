class Solution {
    public void rotate(int[][] matrix) {
        

               
          transpose(matrix);
          reflect(matrix);
        
        
    }
    
    public void reflect(int[][] matrix){
          int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n/2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n- 1- j];
                matrix[i][n-1-j] = tmp;
                
            }
        }
        
    }
    
    
   public void transpose(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
    }
}