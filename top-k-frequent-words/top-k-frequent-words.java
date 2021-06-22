class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        
        Map<String, Integer> map = new HashMap<>();
        
        for(String word: words){
            
            map.put(word, map.getOrDefault(word,0)+1);
        }
        System.out.println(map);
        
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((a,b) -> compare(a, b));
        
      

        for(Map.Entry<String,Integer> ent: map.entrySet()){
          
            pq.offer(ent);
              if(pq.size()>k){
                  pq.poll();
              }
        }
        
       List<String> res = new LinkedList<>();
        
        while(!pq.isEmpty())
            res.add(0, pq.poll().getKey());
        
        return res;
            
    }
    
    private  int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
        int compare = e1.getValue().compareTo(e2.getValue());
        if(compare == 0){
            return e2.getKey().compareTo(e1.getKey());
        }
        return compare;
    }
}