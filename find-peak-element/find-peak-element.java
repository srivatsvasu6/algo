class Solution {
    public int findPeakElement(int[] nums) {
        
        int lo = 0, hi = nums.length-1, mid=0;
        
        while(lo < hi){
            
            
            mid = lo + (hi - lo)/2;
        
          if(nums[mid] > nums[mid+1]){
              hi = mid;
          }else{
                lo = mid +1;}
        }
        
        return lo;
    }
}