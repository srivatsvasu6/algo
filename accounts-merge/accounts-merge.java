class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        
        UnionFind<String> uf = new UnionFind<>();
     Map<String, String> emailToName = new HashMap<String, String>();
        for(List<String> account: accounts){
            
            String name = "";
            
            for(String email: account){
                uf.add(email);
                if(name.equals("")){
                    name  = email;
                    continue;
                }
                
                emailToName.put(email, name);
                uf.union(account.get(1), email);
                
            }
            
            
        }
         Map<String, List<String>> components = new HashMap<String, List<String>>();
        
        for (String email : emailToName.keySet()) {
            String root = uf.find(email);
            components.computeIfAbsent(root, x -> new ArrayList<String>()).add(email);
        }
        List<List<String>> result = new ArrayList<List<String>>();
        
        for (List<String> component : components.values()) {
            Collections.sort(component);
            component.add(0, emailToName.get(component.get(0)));
            result.add(component);
        }
        
        return result;
        
        
    }
    
    public class UnionFind<T>{
        
        Map<T,T> parents;
        Map<T,Integer> weights;
        
        public UnionFind(){
            
            parents = new HashMap<>();
            weights = new HashMap<>();
        }
        
        
        public void add(T node){
            
            if(!parents.containsKey(node)){
                parents.put(node, node);
                weights.put(node, 1);
            }
                
        }
        
        
        public T find(T node){
            
            if(!parents.get(node).equals(node)){
                
                parents.put(node, find(parents.get(node)));
            }
            
            return parents.get(node);
        }
        
        public void union(T n1, T n2){
            
             T i1 = find(n1);
             T i2 = find(n2);
            
            if(i1.equals(i2)){
                return;
            }
            int total = weights.get(i1) + weights.get(i2);
            
            if(weights.get(i1) <= weights.get(i2)){
                
                parents.put(i1, i2);
                
                weights.put(i2, total);
                weights.remove(i1);
                
            }else{
                    
                parents.put(i2, i1);
                
                weights.put(i1, total);
                weights.remove(i2);
                
            }
        }
        
        
    }
}