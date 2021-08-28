class Solution {
    public int findCircleNum(int[][] isConnected) {
        
        int n = isConnected.length;
        UnionFind uf = new UnionFind(n);
        
        for(int i = 0; i<n; i++){
            
            for(int j = 0; j<isConnected[i].length; j++){
                
                if(i!=j && isConnected[i][j]==1){
                    uf.union(i, j);
                }
            }
        }
        
        return uf.size;
        
    }
    
    
}
class UnionFind{
    int[] parents;
    
    int size;
    public UnionFind(int n){
        
        this.size = n;
        parents = new int[n];
        for(int i = 0; i<n ; i++)
            parents[i] = i;
    }
    
    public int find(int i){
        if(parents[i] == i)
            return i;
        return parents[i] = find(parents[i]);
    }
    
    public void union(int i, int j){
        
        int t1 = find(i);
        int t2 = find(j);
        
        if(t1 == t2)
            return;
        
        parents[t2] = t1;
        size--;
    }
}