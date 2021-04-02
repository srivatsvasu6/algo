class Solution {
    public int numSpecial(int[][] mat) {
        
        int w = mat.length;
        int h = mat[0].length;
        int[] c1 = new int[w];
         int[] c2 = new int[h];
        
        for(int i=0; i<w; i++)
            for(int j=0; j<h; j++){
                c1[i] += mat[i][j];
                c2[j] += mat[i][j];
            }
        int ans = 0;
           for(int i=0; i<w; i++)
            for(int j=0; j<h; j++){
                
                if(mat[i][j] ==1 && c1[i]==1 && c2[j]==1){
                    ans++;
                }
                
            }
        return ans;
    }
}