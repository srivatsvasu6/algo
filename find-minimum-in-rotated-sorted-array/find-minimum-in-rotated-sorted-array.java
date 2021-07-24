class Solution {
    public int findMin(int[] nums) {
        
        int i= 0, j = nums.length-1, mid = 0;
        if(i==j){
            return nums[i];
        }
        if(nums[i] < nums[j]){
            return nums[i];
        }
        
        while(i<=j){
            
            mid = i + (j-i)/2;
            
            if(nums[mid] > nums[mid+1]){
                return nums[mid+1];
            }
            
            if(nums[mid-1] > nums[mid]){
                return nums[mid];
            }
            
            if(nums[mid] > nums[i]){
                i= mid+1;
            }else{
                j = mid -1;
            }
            
        }
        return -1;
    }
}