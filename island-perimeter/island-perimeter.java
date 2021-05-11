class Solution {
    public int islandPerimeter(int[][] matrix)   {
    int p = 0, b=0;
    int m = matrix.length;
    int n = matrix[0].length;
      for(int i = 0; i<m; i++ ){

          for(int j=0; j<n; j++){

              if(matrix[i][j]==1){

                p++;

                if(i< m-1 && matrix[i+1][j]==1) b++;
                if(j< n-1 && matrix[i][j+1]==1) b++;
              }
          }
      }

      return p * 4 - b * 2;
        
    }
}