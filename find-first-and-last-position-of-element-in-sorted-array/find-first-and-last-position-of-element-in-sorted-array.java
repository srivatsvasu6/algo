class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        
        return new int[]{getFirst(nums, target),getLast(nums, target) };
   
        
        
    }
    
    public int getLast(int[] arr, int target){
         int lo = 0, hi = arr.length -1, pos = -1, mid = 0;
        boolean found = false;
        
        while(lo <= hi){
            
            mid = lo +(hi-lo)/2;
            
            if(arr[mid] == target){
                found = true; 
                lo = mid +1;
                
            }else  if(arr[mid] < target){
                lo = mid +1;
                
            }else{
                hi = mid -1;
            }
        }
        return found ? hi : -1;
    }
    
      public int getFirst(int[] arr, int target){
         int lo = 0, hi = arr.length -1, pos = -1, mid = 0;
        boolean found = false;
        
        while(lo <= hi){
            
            mid = lo +(hi-lo)/2;
            
            if(arr[mid] == target){
                found = true; 
                hi = mid -1;
                
            }else  if(arr[mid] < target){
                lo = mid +1;
                
            }else{
                hi = mid -1;
            }
        }
        return found ? lo : -1;
    }
}