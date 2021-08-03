class Solution {
    public int minCost(String s, int[] cost) {
        
        int sum = 0, costp= 0;
        char prev = '*';
        
        for(int i = 0; i<s.length(); i++){
            
            
            if(s.charAt(i) == prev){
                
              if(cost[i] > costp){
                  
                  sum += costp;
                  costp = cost[i];
              }else{
                  sum += cost[i];
              }
            
            }else{
                costp = cost[i];
            }
            prev = s.charAt(i) ;
        }
        
        return sum;
    }
}