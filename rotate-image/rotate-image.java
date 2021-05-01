class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i=0; i<n; i++){
            
            for(int j=0; j<i; j++){
                swap(matrix, i, j);
            }
        }
        
    for(int i=0; i<n; i++){
      reverse(matrix[i]);

    }
        
    }
    
    public void swap(int[][] arr, int i, int j){
        int tmp = arr[i][j];
        arr[i][j] = arr[j][i];
        arr[j][i] = tmp;
    }
    
     public void reverse(int[] arr){
      int i=0, j = arr.length-1;
         while(i<j){
             
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
             
            i++;
            j--;
         }
         
       
    }
}

/**
1 4 7
2 5 8
3 6 9
**/