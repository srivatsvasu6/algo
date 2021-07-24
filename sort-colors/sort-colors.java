class Solution {
    public void sortColors(int[] nums) {
        int s = 0, i=0, e = nums.length-1;
        
        while(i<=e){
         
            if(nums[i] ==0){
                swap(nums, i++, s++);
            }else if(nums[i]== 2){
                 swap(nums, e--, i);
            }else{
                i++;
            }
            
            
        }
    }
    
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i]= nums[j];
        nums[j] = temp;
    }
}