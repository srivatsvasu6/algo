class Solution {
    public int[] singleNumber(int[] nums) {
       int axb = 0, n1=0, n2=0;
        
        for(int n: nums){
           axb ^= n;
        }
        
        int rightSet = 1;
        
        while ((axb & rightSet )== 0){
         rightSet =   rightSet << 1;
        }
        
        
        for(int n: nums){
            if((n & rightSet) ==0)
             n1 ^= n;
            else
             n2 ^= n;   
        }
        
        return new int[]{n1,n2};
    }
}