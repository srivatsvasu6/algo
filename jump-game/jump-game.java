class Solution {
    public boolean canJump(int[] nums) {
        
        Index[] memo = new Index[nums.length];
        Arrays.fill(memo, Index.UNKNOWN);
     
        memo[memo.length-1] = Index.GOOD;
        
        for(int i = nums.length -2; i>=0; i--){
            
            int maxJum = Math.min(nums[i]+ i, nums.length-1);
           
            for(int j = i+1; j<=maxJum; j++){
                
                if(memo[j] == Index.GOOD){
                    memo[i] = Index.GOOD;
                    break;
                }
            }
        }
        
        return memo[0]==Index.GOOD;
    }
    
    
}

enum Index{
    BAD, UNKNOWN, GOOD
}