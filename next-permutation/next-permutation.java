class Solution {
    public void nextPermutation(int[] nums) {
       
       int pivot = findLastPeakIndex(nums) -1;
        
        if(pivot!=-1){
            int index = lastIndexOfGreater(nums, nums[pivot]);
            
            swap(nums,pivot, index);
            
        }
        reverse(nums, pivot+1);
        
    }
    
     public int lastIndexOfGreater(int[] arr, int val){
        for(int i= arr.length -1; i>=0; i--){
        
            if(arr[i] > val){
                return i;
            }
        }
        return -1;
    }
    
    public int findLastPeakIndex(int[] arr){
        for(int i= arr.length -1; i>0; i--){
        
            if(arr[i] > arr[i-1]){
                return i;
            }
        }
        return 0;
    }
    
    public void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    
    }
    
    public void reverse(int[] arr, int i){
        int j = arr.length -1;
        while(i<j)
            swap(arr, i++, j--);
    }
}