class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
     
      Map<String, Integer> map = new HashMap<>();
        String[] words = paragraph.replaceAll("[^a-zA-Z0-9]+"," ").split("\\s+");
           Set<String> bannedSet = Arrays.stream(banned)
            .collect(Collectors.toSet());
        for(String word: words){
            
           String key = word.toLowerCase();
           
            if(!bannedSet.contains(key))
            map.put(key, map.getOrDefault(key,0)+1);
            
            
        }
        System.out.println(map);
    
      return map.entrySet()
            .stream()
            .max(Comparator.comparing(Map.Entry::getValue))
            .map(Map.Entry::getKey)
            .orElse("");
    }
}