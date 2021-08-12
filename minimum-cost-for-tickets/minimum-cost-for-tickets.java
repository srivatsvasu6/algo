class Solution {
    Integer[] memo;
    int[] dur = new int[]{1, 7, 30};
    public int mincostTickets(int[] days, int[] costs) {
        memo = new Integer[days.length];
        
      return helper(days, costs, 0);
    }
    
    public int helper(int[] days, int[] costs, int i){
        
        if(i >= days.length)
            return 0;
        
        if(memo[i] !=null)
            return memo[i];
        
        int j = i;
        int cos = Integer.MAX_VALUE;
        
        for(int k =0; k<3; k++){
            
            while(j < days.length && days[j] < dur[k] + days[i])
                j++;
            
            cos= Math.min(cos, helper(days, costs, j)+ costs[k]);
        }
            
             memo[i] = cos;
        return cos;
    }
}