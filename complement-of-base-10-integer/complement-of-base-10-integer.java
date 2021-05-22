class Solution {
    public int bitwiseComplement(int n) {
        if(n==0)
            return 1;
        
      int a = n, cnt =0;
        
        while(a>0){
            cnt++;
            a = a >> 1;
        }
        
        a = (int) Math.pow(2, cnt) - 1;
        
        return a ^n;
        
        
    }
}