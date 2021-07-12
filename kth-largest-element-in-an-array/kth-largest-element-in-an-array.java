class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        int size = nums.length;
        
       return  quickSelect(nums, 0, size-1, size-k);
        
        
    }
    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    private  int partition(int[] nums, int lo, int hi, int pivot_idx){
        int pivot = nums[pivot_idx];
        
        swap(nums, pivot_idx, hi);
        
       for(int i = lo; i<= hi; i++){
           
           if(nums[i] < pivot){
               swap(nums, i, lo);
               lo++;
           }
       }
        
        swap(nums, lo, hi);
        
        return lo;
        
    }
    
    private int quickSelect(int[] nums, int lo, int hi, int k_small){
        
        while(lo <=hi)
        {
            if(lo == hi)
                return nums[lo];
        
        Random rand = new Random();
        int pivot_idx =   lo + rand.nextInt(hi - lo);
            
        pivot_idx = partition(nums, lo, hi, pivot_idx);
        
        if(pivot_idx < k_small ){
            lo = pivot_idx + 1;
        }else if(pivot_idx > k_small){
            hi = pivot_idx -1;
            
        }else{
            return nums[pivot_idx];
        }
            
            
        
        }
        
        return -1;
    }
}