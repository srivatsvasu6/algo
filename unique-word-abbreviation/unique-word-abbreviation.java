class ValidWordAbbr {

Map<String,  Set<String>> map = null;
    
    
    public ValidWordAbbr(String[] dictionary) {
        map = new HashMap<>();
        
        for(String word: dictionary){
             String key =  abbreviate(word);
             if(!map.containsKey(key)){
                 map.put(key,new HashSet<>());
             }
              
            map.get(key).add(word);
            
        }
    }
    
    public boolean isUnique(String word) {
        
       String key =  abbreviate(word);
        if(map.containsKey(key)){
            if(map.get(key).contains(word) && map.get(key).size() ==1 ){
                return true;
            }
            return false;
        }
      //  set.add(key);
        return true;
    
    }
    public String abbreviate(String word){
        
        int n = word.length();
        if(n<=2){
            return word;
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(word.charAt(0));
        sb.append(n-2);
        sb.append(word.charAt(n-1));
        return sb.toString();
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */