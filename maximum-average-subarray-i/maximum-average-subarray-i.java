class Solution {
    public double findMaxAverage(int[] nums, int k) {
        
        int start=0, j=nums.length;
        double avg = 0.0, sum=0.0, max = -Double.MAX_VALUE;
        
        for(int i=0; i<j; i++){
            
            sum += nums[i];
            
            if(i - start +1  >= k){
                
                avg = sum/k;
                System.out.println(avg);
               
                if(avg >= max ){
                    max = avg;
                }
           
                sum -= nums[start++];
                
            }
        }
        
      
        
        return max;
        
    }
}