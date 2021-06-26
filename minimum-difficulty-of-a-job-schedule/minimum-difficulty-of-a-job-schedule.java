class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        
        int N = jobDifficulty.length;
        if(d > N){
            return -1;
        }
        int[][] memo = new int[d-1][N];
    
        for(int[] m: memo)
            Arrays.fill(m, -1);
        
        return dfs(jobDifficulty, d-1, 0,memo);
        
    }
    
    public int dfs(int[] k, int d, int pos, int[][] memo){
        int max =0;
        if(d == 0){
           max = k[pos];
           for(int i=pos; i< k.length; i++){
               max = Math.max(max, k[i]);
           } 
            return max;
        }
        int day = memo.length -d;
        
        if(memo[day][pos] !=-1){
            return memo[day][pos];
        }
         max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for(int i = pos; i<k.length-d; i++){
            max = Math.max(max, k[i]);
            min = Math.min(min, max + dfs(k, d-1, i+1, memo));
        }
        return memo[day][pos] = min;
    }
}