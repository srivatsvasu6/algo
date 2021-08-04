class Solution {
    public int minIncrementForUnique(int[] nums) {
        
        Arrays.sort(nums);
        
        int need = 0, res = 0;
        
        for(int num : nums){
            
            res += Math.max(need - num , 0);
            need = Math.max(need, num) + 1;
        }
        
        return res;
    }
}