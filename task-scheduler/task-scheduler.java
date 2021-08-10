class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        if(n==0)
            return tasks.length;
        
        Map<Character, Integer> freq = new HashMap<>();
        
        for(char task: tasks){
            
            freq.put(task, freq.getOrDefault(task,0)+1);
        }
        
        PriorityQueue<Map.Entry<Character,Integer>> pq = new PriorityQueue<>((a,b)-> (b.getValue() == a.getValue())? a.getKey()-b.getKey(): b.getValue() - a.getValue());
        int k = 0;
        pq.addAll(freq.entrySet());
       
       
        int count = 0;
        
        while(!pq.isEmpty()){
            k = n + 1;
         List<Map.Entry<Character,Integer>> ls = new ArrayList<>();
        
            while( !pq.isEmpty() && k > 0 )
           { 
                Map.Entry<Character, Integer> ent = pq.poll();
                ent.setValue(ent.getValue() - 1);
                System.out.print(ent.getKey()+"->");
                if(ent.getValue() > 0){
                    ls.add(ent);
                }
                k--;
                count++;
           }
              pq.addAll(ls);
        
            if(pq.isEmpty())
                break;

            IntStream.of(k).forEach(i-> System.out.print("idle->"));
            
            count += k;
        
        
          
            
            
        }
        
        return count;
    }
}