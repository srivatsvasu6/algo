class Solution {
    public int[] countBits(int num) {
        
        
        int[] res = new int[num+1];
        for(int i=0; i<=num; i++){
            res[i] = countBit(i);
        }
        
        return res;
        
    }
    
    public int countBit(int n){
        int count = 0;
        while(n !=0 ){
            n = n & n-1;
            count++;
        }
        return count;
    }
}