class Solution {
    public int orangesRotting(int[][] matrix) {
        Queue<Zombie> queue = new LinkedList<>();
	int res = 0, m = matrix.length, n = matrix[0].length, fresh=0;
		for(int i=0; i<m; i++){
		    for(int j =0; j<n; j++){
		        if(matrix[i][j]==2)
		            queue.offer(new Zombie(i,j, 0));
                else if(matrix[i][j]==1)
                    fresh++;
		    }
		}
		
		int[][] dir = {{-1,0},{0, 1},{1, 0},{0,-1}};
		while(!queue.isEmpty()){
		    
		   
		   Zombie node = queue.poll();
		  
            for(int[] d : dir){
                
                int nr = d[0]  +  node.row;
                int nc = d[1] + node.col;
                
                if(nr>=0 && nc >=0 && nr <m && nc< n && matrix[nr][nc]==1){           matrix[nr][nc]= 2;
                                                                                         fresh--;
                    queue.offer(new Zombie(nr, nc, node.round+1));
                }
            }
            
		    res = Math.max(res, node.round);
		   
		    
		}
		
		return fresh==0? res: -1;
    }
    
    static class Zombie{
        
        int row;
        int col;
        int round;
        
        public Zombie( int row, int col, int round){
            this.row= row;
            this.col= col;
            this.round = round;
        }
    }
    
   
     
    
	
}