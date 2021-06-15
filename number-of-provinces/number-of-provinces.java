class Solution {
    public int findCircleNum(int[][] isConnected) {
        int m = isConnected.length;
        int n = isConnected[0].length;
        UnionFind uf = new UnionFind(n);
        for(int i=0; i<m; i++){
            
            for(int j=0; j<n; j++){
                
                if(isConnected[i][j]==1){
                    uf.union(i, j);
                }
            }
        }
        
        return uf.getSize();
    }
    
    class UnionFind{
        
        int[] parents;
        int[] weights;
        int nodes =0;
        public UnionFind(int n){
            parents = new int[n];
            weights = new int[n];
            nodes = n;
            for(int i = 0; i<n; i++){
                parents[i] = i;
                weights[i] = 1;
            }
        }
        
        public int find(int i){
            if(parents[i] !=i){
                parents[i] = find(parents[i]);
            }
            return parents[i];
        }
        
        public void union(int i1, int i2){
            
            int n1 = find(i1);
            int n2 = find(i2);
            
            if(n1 == n2){
                return;
            }
            nodes--;
            
            int size = weights[n1] + weights[n2];
            
            if(weights[n1] >= weights[n2]){
                parents[n2] = n1;
                weights[n1] = size;
                weights[n2] = 0;
            }else{
                parents[n1] = n2;
                weights[n2] = size;
                weights[n1] = 0;
            }
        }
        
        public int getSize(){
            return nodes;
        }
        
        
    }
}