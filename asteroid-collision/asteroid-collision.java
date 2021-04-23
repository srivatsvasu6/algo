class Solution {
    public int[] asteroidCollision(int[] a) {
        
        if(a == null || a.length<2){
            return a;
        }
        
        int prev = 0, curr =1;
        
        while(curr < a.length){
            
            if(prev >=0 && a[curr] < 0 && a[prev] > 0){
                
                if(a[prev] > -a[curr]){
                    curr++;
                }else  if(a[prev] < -a[curr]){
                    prev --;
                }else{
                     curr++;
                     prev--;
                }
                
                
            }else{
                
                a[++prev] = a[curr++];
            }
            
            
            
        }
        return Arrays.copyOf(a, prev+1);
        
    }
}