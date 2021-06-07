class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length==1)
            return true;
        
        
        int maxReach = nums[0], steps = nums[0], jump = 0;
        
        for(int i=1; i< nums.length-1; i++){
            
            maxReach = Math.max(maxReach, nums[i]+i);
            
            steps--;
            if(steps ==0){
                
                jump++;
                steps = maxReach -i;
                
            }
        }
        
        System.out.println( jump+1);
       System.out.println( maxReach+ " " + steps);
        return steps>0;
    }
}