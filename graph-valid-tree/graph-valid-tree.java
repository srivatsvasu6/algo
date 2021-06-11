class Solution {
    public boolean validTree(int n, int[][] edges) {
        
        UnionFind<Integer> uf = new UnionFind<>();
        
        for(int i=0; i<n; i++){
            uf.add(i);
        }
        
        
        for(int[] edge : edges){
            
            
            int n1 = uf.find(edge[0]);
            int n2 = uf.find(edge[1]);
            
            if(n1 == n2){
                return false;
            }
            
            uf.union(edge[0], edge[1]);
            
            
        }
        
        return uf.getTotalNumberOfDisjointSets() == 1;
        
    }
    
    public class UnionFind<T>{
        
        Map<T,T> parents;
        Map<T,Integer> weights;
        
        
        public UnionFind(){
            parents = new HashMap<>();
            weights = new HashMap<>();
        }
        
        public void add(T item){
            
            parents.put(item, item);
            weights.put(item, 1);
        }
        
        public boolean isPresent(T item){
            return parents.containsKey(item);
        }
        
        public T find(T item){
            
            if(!parents.get(item).equals(item)){
                parents.put(item, find(parents.get(item)));
            }
            return parents.get(item);
        }
        
        public void union(T item1, T item2){
            
            T root1 = find(item1);
            T root2 = find(item2);
            
            if (root1.equals(root2)) {
                return; 
            }
            int newSize = weights.get(root1) +  weights.get(root2);
            
            if(weights.get(root1)<= weights.get(root2)){
                
                parents.put(root1, root2);
                weights.put(root2, newSize);
                weights.remove(root1);
            }else{
                parents.put(root2, root1);
                weights.put(root1, newSize);
                weights.remove(root2);
            }
            
        }
        
        public int getTotalNumberOfDisjointSets() {
            return weights.size();
        }
        
    }
}