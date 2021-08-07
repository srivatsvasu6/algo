class Solution {
    public boolean canReach(int[] arr, int start) {
        
     
        Queue<Integer> queue = new LinkedList<Integer>();
        
        queue.offer(start);
        
        
        while(!queue.isEmpty()){
            
            int val = queue.poll();
            
   
        
            if(arr[val] ==0)
                return true;
            
            if(arr[val] <0)
                continue;
            
            int left = val - arr[val];
            int right = val + arr[val];

            
            if( left >= 0 )
                queue.offer(left);
            
            if( right < arr.length)
                queue.offer(right);
            
            arr[val] = -arr[val];
        }
        
        return false;
    }
}