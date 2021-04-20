class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> a-b);
        
      for(int num: nums){
          
          pq.add(num);
      }
          
        for(int i=k; i<nums.length; i++){ 
            
           
                pq.poll();
             
            
        }
       
        return pq.peek();
        
    }
}