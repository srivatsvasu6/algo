class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        
        
        int n = edges.length;
        
        UnionFind uf = new UnionFind(1000+1);
        List<int[]> res = new ArrayList<>();
        for(int[] edge: edges){
            
            if(!uf.union(edge[0], edge[1])){
               return edge;
            }
            
        }
        
        return new int[]{-1,-1};
        
    }
    
    public class UnionFind{
        
        int[] parents;
        int[] rank;
        
        public UnionFind(int n){
            parents = new int[n];
            rank = new int[n];
            for(int i =0; i<n; i++){
                parents[i] = i;
            
            }
        }
        
        public int find(int x) {
        if (parents[x] != x) parents[x] = find(parents[x]);
        return parents[x];
        }

        
        public boolean union(int i, int j){
            int i1 = find(i);
            int i2 = find(j);
            
            if(i1 == i2){
                return false;
            } else if(rank[i1]> rank[i2]){
                parents[i2] = i1;
            }else if(rank[i2] > rank[i1]){
                parents[i1] = i2;
            }else{
                parents[i2] = i1;
                rank[i1]++;
            }
            
            
            
            return true;
            
            
        }
    }
}