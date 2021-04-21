class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        
  
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> b-a);
        for(int[] num: matrix){
            
            for(int j: num){
                
                pq.offer(j);
                
                if(pq.size() > k){
                    pq.poll();
                }
                
            }
        }
        
        return pq.peek();
    }
}