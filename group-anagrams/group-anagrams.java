class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if(strs == null || strs.length ==0)
            return res;
        
        Map<String, List<String>> map= new HashMap<>();
        
        for(String s : strs){
            char[] ca = new char[26];
            for(char c: s.toCharArray()){
                
                ca[c-'a']++;
            }
            String key = String.valueOf(ca);
            
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }
        res.addAll( map.values());
        return res;
        
    }
}