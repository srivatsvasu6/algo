class Solution {
    int res =0;
    public int countSubstrings(String s) {
     

        if(s== null || s.length() ==0){
         
           return 0;
        }
        int cnt = 0;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

         for(int i=0; i< n; i++){
              dp[i][i] = true;
             cnt++;
         }
        
        for(int i=0; i< n-1; i++){
        
          dp[i][i+1] = s.charAt(i) == s.charAt(i+1);
            if( dp[i][i+1]){
                cnt++;
            }
        }
        
        for(int len=3; len<=n; len++){
            
            for(int i=0, j=i+len-1; j<n; i++,j++){
                dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i+1][j-1];
             if( dp[i][j]){
                cnt++;
            }
            }
        }
        
        
        return cnt;
    }
    
    public void isPalindrome(String s, int l, int r){
        
        while (l >=0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            res++; r++; l--;
        }
    }
}