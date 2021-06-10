class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        
        Map<String, Set<Integer>> map = new HashMap<>();
          List<String> res = new ArrayList<>();
        
        for(int i =0; i< keyName.length; i++){
            
         String[] time =   keyTime[i].split(":");
            
        int val =  Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
            
           if(! map.containsKey(keyName[i])){
               map.put(keyName[i],new TreeSet<>());
           }
            map.get(keyName[i]).add(val);
        }
      
        for(Map.Entry<String, Set<Integer>> e:  map.entrySet()){
            
            List<Integer> s =  new ArrayList<>(e.getValue());
         
        
            for(int i = 2; i<s.size(); i++){
                
                if(s.get(i) - s.get(i-2) <= 60){
                    res.add(e.getKey());
                    break;
                }
            }
            
            
        }
        
        Collections.sort(res);
        return res;
        
    }
}