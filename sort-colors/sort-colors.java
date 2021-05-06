class Solution {
    public void sortColors(int[] nums) {
        int start =0, mid = 0, end= nums.length-1;
      
        
        while(mid<=end){
            
            if(nums[mid]<1){
                swap(nums,mid, start);
                start++;
                mid++;
            }
             else if(nums[mid] >1){
                 swap(nums,mid, end);
                 end--;
             }else {
                   mid++;
             }
          
        }
        
    
    }
    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}