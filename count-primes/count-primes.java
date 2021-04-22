class Solution {
    public int countPrimes(int n) { 
        
        if(n<2) return 0;
        
        boolean[] nums = new boolean[n];
        
        for(int i=2; i<Math.sqrt(n); i++){
            
            if(nums[i]==false){
                
                for(int p = i*i; p< n; p+=i){
                    
                    nums[p] = true;
                }
            }
        }
        int res =0;
        for(int i=2; i<n; i++){
            if(nums[i]==false){
                res++;
            }
        }
        return res;
    }
}