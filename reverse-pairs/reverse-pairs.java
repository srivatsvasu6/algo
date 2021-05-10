class Solution {
 
    public int reversePairs(int[] nums) {
        
    
       int res =  mergeSort(nums, 0, nums.length -1);

        return res;
    }
    
  public int mergeSort(int[] nums, int low, int hi){

        if(hi <= low){
             return 0;
        }
        
        int mid = low+ (hi - low)/2;
        
        int inv = mergeSort(nums, low,  mid);
      
        inv += mergeSort(nums, mid + 1,  hi);
      
        inv +=  merge(nums, low, mid, hi);
      
      return inv;
          
    }
    
    public int merge(int[] nums, int left, int mid, int right){
    
     int cnt =0, j= mid + 1;
       List<Integer> ls = new ArrayList<>();
        
        for(int i=left; i<=mid; i++){
            
            while(j<=right && nums[i] > 2L * nums[j] ){
                j++;
            }
            
            cnt += j - (mid +1);
        }
       
        int l = left, k=0;
        j = mid+1;
        
        while(l<= mid && j<= right){
            
            if(nums[l] < nums[j]){
                ls.add(nums[l++]);
            }else{
               
                 ls.add(nums[j++]);
            }
            
        }
        while(l<=mid){
             ls.add(nums[l++]);
        }
        
        while(j <= right){

          ls.add( nums[j++]); 
        }
        
        for(int i=left; i<=right; i++){
            
            nums[i] = ls.get(i-left);
        }
        
        return cnt;
        
        
    }
}