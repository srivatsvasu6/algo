class Solution {
    public int search(int[] nums, int target) {
        
        int lo = 0, hi = nums.length-1, mid = 0, end = hi;
        
        while(lo <= hi){
            
            mid = lo + (hi - lo)/2;
            
            if(nums[mid] == target ){
                return mid;
            }else if(nums[mid] >= nums[0] ){
                
             if(target >= nums[0] && target < nums[mid] ){
                    hi = mid -1;
             }else{
                 lo = mid +1;
             }
            }else{
                
              if(target <= nums[end] && target > nums[mid] ){
                    lo = mid + 1;
             }else{
                 hi = mid -1;
             }
            }
        }
        return -1;
            
            
    }
}