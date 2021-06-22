class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        
        Map<String, Integer> map = new HashMap<>();
        
        for(String word: words){
            
            map.put(word, map.getOrDefault(word,0)+1);
        }
        System.out.println(map);
        
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((a,b) -> compare(b, a));
        
        pq.addAll(map.entrySet());
       List<String> res = new ArrayList<>();
        for(int i=0; i<k; i++){
            if(!pq.isEmpty()){
                res.add(pq.poll().getKey());
            }
        }
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