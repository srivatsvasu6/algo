class Solution {
    public int minFallingPathSum(int[][] A) {
       int m= A.length; 
       
        
        for(int i = 1 ; i<m; i++ ){
            for(int j = 0; j<m; j++){
   
            
              A[i][j] += Math.min(A[i - 1][j], Math.min(A[i - 1][Math.max(0, j - 1)], A[i - 1][Math.min(m - 1, j + 1)]));

            }
     
        }
        
          return Arrays.stream(A[m - 1]).min().getAsInt();
    }
}