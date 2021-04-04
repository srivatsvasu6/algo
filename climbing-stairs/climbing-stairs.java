class Solution {
    public int climbStairs(int n) {
        
      int[] mem = new int[n+2];
        
       return climb(0, n,mem);
        
    }
    
    private int climb(int i , int n, int[] mem){
        
        if(mem[i]!=0){
            return mem[i];
        }
        
        if(i> n){
            return 0;
        }
        
        if(i==n){
            return 1;
        }
        
        int res = climb(i+1, n,mem) + climb(i+2, n,mem);
        
        mem[i] = res;
        return res;
        
    }
}