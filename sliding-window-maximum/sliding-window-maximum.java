class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        Deque<Pair> deque = new ArrayDeque<>();
        
        int n = nums.length;
        int w = n - k +1;
        int start = 0;
        
        int[] res = new int[w];
        
        for(int i = 0; i<n; i++){
 
            // Remove if the top is outside the window.
           if(!deque.isEmpty() && deque.peekFirst().index <= i - k ){
                deque.pollFirst();   
            }
          
            // Pop the deque when till we find a greater element and insert
            
            while(!deque.isEmpty() && deque.peekLast().val < nums[i] ){
                deque.pollLast();
            }
            deque.offerLast(new Pair(nums[i], i));
            
            if(i >= k -1){
                res[start++] = deque.peekFirst().val;
            }
          
        }
        return res;
        
    }
    
    class Pair{
        int val, index;
        
        public Pair(int val, int index){
            this.val = val;
            this.index = index;
        }
    }
    
  
}