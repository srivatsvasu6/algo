class Solution {
    public int longestConsecutive(int[] nums) {
        
        if(nums ==null || nums.length==0){
            return 0;
        }
        
        UnionFind<Integer> unionFind = new UnionFind<>();
        
        
        for(int num: nums){
            
             if (unionFind.isPresent(num)) { 
                 continue;
            }
            unionFind.add(num);
            
            if(unionFind.isPresent(num+1)){
                unionFind.union(num, num+1);
            }
             if(unionFind.isPresent(num-1)){
                unionFind.union(num, num-1);
            }
        }
        
        
        int max = Integer.MIN_VALUE;
        for (int size : unionFind.getComponentSizes().values()) {
            max = Math.max(max, size);
        }
        return max;
    }
    
    
    public class UnionFind<T>{
     
        Map<T,T> parents;
        Map<T,Integer> weights;
        
         public UnionFind() {
            parents = new HashMap<>();
            weights = new HashMap<>();
        }
        
        public void add(T newItem){
            
                parents.put(newItem, newItem);
                weights.put(newItem,1);
        }
        
         public boolean isPresent(T item) {
             
           return parents.containsKey(item);
             
         }
        public Map<T, T> getParents() {
            return parents;
        }
        
        public Map<T, Integer> getComponentSizes() {
            return weights;
        }
        
        public T find(T node){
            
            if (!parents.get(node).equals(node)) {
                
                 parents.put(node, find(parents.get(node))); 
            }
            
            return parents.get(node);
        }
        
        public void union(T node1, T node2) {
            
            T item1 = find(node1);
            T item2 = find(node2);
            
           if(item2.equals(item1)){
               return;
           }
            
           int newSize = weights.get(item1) + weights.get(item2);
            
            
            if(weights.get(item2) >= weights.get(item1) ){
                
                parents.put(item1, item2);
                weights.put(item2, newSize);
                weights.remove(item1);
            }else{
                
                parents.put(item2, item1);
                weights.put(item1, newSize);
                weights.remove(item2);
            }
            
        }
        
        public int getTotalNumberOfDisjointSets() {
            return weights.size();
        }
        
    }
}