class Solution {
    public List<Integer> getRow(int n) {
        
   
        Integer[] res = new Integer[n+1];
        res[0]=1;

        long k = n;
 
        for(int i=1; i<=n; i++){
         
                res[i] = (int) (res[i-1]  * (k -i +1) / i);
           
                     
        }
        
   
        
        return Arrays.asList(res);
    }
}