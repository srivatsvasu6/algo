class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String,Integer> map = new HashMap<>();
        
        for(String domain: cpdomains){
            
           String[] entry = domain.split(" ");
            
            int count = Integer.valueOf(entry[0]);
            
            String[] domainNames = entry[1].split("\\.");
            
            String str = "";
            
            for(int i=domainNames.length-1; i>=0; i--){
             
                
                str = domainNames[i] + (i < domainNames.length-1 ? "." :"" )+ str;
                
                map.put(str, map.getOrDefault(str,0)+ count);
            }

        }
        
         List<String> ans = new ArrayList();
        for (String dom: map.keySet())
            ans.add( map.get(dom) + " " + dom);
        return ans;
    }
}