class Solution {
    public int subarraySum(int[] nums, int k) {
        int start= 0, i=0, end = nums.length, sum = 0, count =0;
  
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        while(i< end){
            
            sum += nums[i++];
            
        
             if(map.containsKey(sum - k))
                  count += map.get(sum-k);
             
                
               map.put(sum, map.getOrDefault(sum,0)+1);
         
        }
        
     
        return count;
        
        
    }
}