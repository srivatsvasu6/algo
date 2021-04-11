class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc]!= newColor){
             dfs(image, new Coordinates(sr, sc), newColor);
        }
       
        return image;
        
        
    }
    
    public void dfs(int[][] image, Coordinates start,  int newColor ){
        
      
      int numRows = image.length;
      int numCols= image[0].length;
      int color = image[start.x][start.y];
    //  image[start.x][start.y] = newColor;
      Queue<Coordinates> queue = new LinkedList<>();
      queue.offer(start);
        
      while(!queue.isEmpty())  {
        
        Coordinates node = queue.poll();
        image[node.x][node.y] = newColor; 
        List<Coordinates>  pixels = getNeighbour(node, numRows, numCols);

        for(Coordinates pixel: pixels){
            if(image[pixel.x][pixel.y] == color ){
                image[pixel.x][pixel.y] = newColor;
                queue.offer(pixel); 
            }
         
           
        }
            
      } 
    }
    
    public  List<Coordinates> getNeighbour(Coordinates start, int numRows, int numCols){
      List<Coordinates> coordinates = new ArrayList<>();
  
        
         int[] deltaRow = {-1,0,1,0};
         int[] deltaCol = {0,1,0,-1};
        
        for(int i=0; i<deltaRow.length; i++){
            
            int nr = deltaRow[i] + start.x;
            int nc = deltaCol[i] + start.y;
            
            if(0<= nr && nr<numRows && 0<= nc && nc< numCols){
                coordinates.add(new Coordinates(nr, nc));
            }
        }
        
        return coordinates;
        
    }
    
    class Coordinates{
        int x,y;
        Coordinates(int x, int y){
            this.x =x;
            this.y =y;
        }
    }
}