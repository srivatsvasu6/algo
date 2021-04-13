class Solution {
    public int totalFruit(int[] tree) {
        
        Map<Integer,Integer> basket = new HashMap<>();
        int start =0, max = 0;
        for(int i=0; i<tree.length; i++){
            
            basket.put(tree[i], basket.getOrDefault(tree[i],0)+1);
            
            while(basket.size() > 2){
                
                int fruit = tree[start++];
                
                if(basket.containsKey(fruit)){
                      basket.put(fruit, basket.get(fruit) - 1);
                    if(basket.get(fruit) ==0){
                        basket.remove(fruit);
                    }
                }
                
            }
            max = Math.max(max, i+1 - start);
            
            
        }
        
        return max;
    }
}