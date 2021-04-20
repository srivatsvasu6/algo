class KthLargest {
    PriorityQueue<Integer> pq = null;
int k = 0;
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>(k);
        this.k = k;
        
      for(Integer num : nums){
          
         pq.offer(num);
          
          if(pq.size() > k){
              pq.poll();
          }
      
         
      }
        
    }
    
    public int add(int val) {
       
        pq.offer(val);
        if (pq.size() > k) {
            pq.poll();
        }
        return pq.peek();
        
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */