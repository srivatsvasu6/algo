class Solution {
    public int[] asteroidCollision(int[] a) {
      int[] s = new int[a.length];
        int prev =0 , curr=1;
      while(curr< a.length){
            
            if(prev ==-1){
              a[0] = a[curr];
               prev++;
               curr++;
            }else{
            
                if(a[prev] > 0 && a[curr] < 0){
                    if(-a[curr] == a[prev]){
                            prev--;
                            curr++;
                    }else if(a[prev] > -a[curr]){
                         curr++;
                    }else{
                          prev--;
                    }
                }else{
                    ++prev;
                    a[prev] = a[curr];
                    curr++;
                    
                }
            }
        }
            
        
      
        return Arrays.copyOf(a, prev+1);
        
    }
}