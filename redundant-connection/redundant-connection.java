class Solution {
    public int[] findRedundantConnection(int[][] edges) {
       int n =edges.length;
        int[] parents = new int[n+1];
        
        for(int i=0; i<=n; i++)
            parents[i] = i;
        
        int[] res = new int[2];
        
        for (int i = 0; i < n; i++) {
 			int x = find(edges[i][0], parents);
 			int y = find(edges[i][1], parents);
 			if (x != y)
 				parents[y] = x;
 			else {
 				res[0] = edges[i][0];
 				res[1] = edges[i][1];
 			}
 		}
        
        return res;
    
    }
    
    public int find(int val, int[] parents){
       return parents[val] == val? val: find(parents[val], parents);
    }
}