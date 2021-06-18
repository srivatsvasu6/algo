class Solution {
    public int maxDistToClosest(int[] seats) {
        
       
        int max = -1, last = -1, n = seats.length-1;
        
        
        
      for(int i = 0; i<=n; i++){
  
          if(seats[i]==1){
              
              if(last==-1)
                   max =  Math.max(max,i  ) ;
              else
                   max =  Math.max(max, (i - last ) / 2 ) ;
                  
              last = i;
          }
          
          
      }
        if(seats[n]==0)
          max =  Math.max(max,  n - last ) ;
        
        return max;
        
    }
}