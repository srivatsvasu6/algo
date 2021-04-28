class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        Map<Character, Integer> freq = new HashMap<>();
        
        for(char ch: tasks){
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }
        int cnt =0;
      PriorityQueue< Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a,b)-> b.getValue() - a.getValue());
        
        pq.addAll(freq.entrySet());
        
        while(!pq.isEmpty()){
            
            int k = n+1;
            List<Map.Entry<Character, Integer>> waitList = new ArrayList<>();
            
            for(; k>0 && !pq.isEmpty(); k--){
                cnt++;
                Map.Entry<Character, Integer> top = pq.poll();
                
                if(top.getValue() > 1){
                    top.setValue(top.getValue()  -1 );
                    waitList.add(top);
                }
     
            }
            pq.addAll(waitList);
            
            if (!pq.isEmpty())
            cnt += k;

        }
        
       
        return cnt;
        
       
        
    }
}