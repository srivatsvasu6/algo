class Solution {
    public int[] sumZero(int n) {
      if(n == 1)
          return new int[]{0};
        int j =0;
        
        int[] res = new int[n];
        
        
        for(int i=1; i<=n/2; i++){
            res[j++]= i;
            res[j++]= -i;
        }
        
        if(n % 2 !=0){
            res[j] = 0;
        }
        return res;
    }
}