class Solution {
    public int fib(int n) {
        if(n<0) return 0;
        if(n<2) return n;
        int f1 = 0, f2 = 1, fib = 0;
        for(int i = 2; i<= n; i++){
            
            fib = f1 + f2;
            f1= f2;
            f2 = fib;
        }
        
        return fib;
            
    }
}