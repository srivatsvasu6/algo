class Solution {
    public int numUniqueEmails(String[] emails) {
      
        
       Map<String, Set<String>> domains = new HashMap<>();
        
        for(String email : emails){
            
         String[] em =  email.split("@");
            
          if(!domains.containsKey(em[1])){
              domains.put(em[1], new HashSet<>());
          }
         String e =   em[0].replaceAll("[.]","");
            
         String res =    e.split("[+]")[0];
            
         domains.get(em[1]).add(res);
            
        }
        
        int count = 0;
        
        for(Map.Entry<String,Set<String>>  entry: domains.entrySet()){
            
            count += entry.getValue().size();
            
        }
        
       return count;
        
    }
}