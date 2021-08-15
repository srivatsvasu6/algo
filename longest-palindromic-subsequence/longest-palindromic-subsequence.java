class Solution {
    public int longestPalindromeSubseq(String s) {
        
       int m = s.length();
       int[] dp = new int[m+1];
        for(int i = m-1; i >=0;  i--){
            for(int j = m-1, prev=0, next; j >=0; j--){
                next = dp[j];
                if(s.charAt(i) != s.charAt(m-j-1)){
                    dp[j] = Math.max(dp[j+1], dp[j]);
                }else{
                    dp[j] = prev +1;
                }
                prev = next;
            }
        }
        return dp[0];
        
        
    }
}