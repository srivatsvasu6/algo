class Solution {
    public double knightProbability(int n, int k, int r, int c) {
        
        
        double[][] curr = new double[n][n];
        double[][] next = new double[n][n];
        
        curr[r][c]=1.0;
        
        int ni, nj;
        int[] dr = new int[]{-2,-1,1,2,2,1,-1,-2};
         int[] dc = new int[]{1,2,2,1,-1,-2,-2,-1};

        for(int m=0; m<k; m++){

            for(int i=0; i<n; i++){
                
                for(int j=0; j<n; j++){
                    
                    for(int h =0; h<8; h++){
                    
                    ni = i + dr[h];
                    nj = j+ dc[h]; 
                        
                      if(0<= ni && 0<= nj && ni <n && nj < n  ) {
                          next[ni][nj] += curr[i][j] /8.0;
                      }
                        
                    }
                  
                    
                }
            }
            
            curr = next;
            next = new double[n][n];
        }
    
    double ans = 0.0;
    
    for(double[] row : curr){
        for(double x: row){
            ans += x;
        }
    }
        return ans;
    }
}