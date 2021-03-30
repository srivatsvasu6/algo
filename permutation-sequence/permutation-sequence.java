class Solution {

    
    public String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
       
       
        for(int i= 1; i<=n; i++){
           numbers.add(i);
        }
        int[] fact = new int[n+1];
        
        fact[0] = 1;
        int sum= 1;
        for(int i=1; i<=n; i++){
            sum *= i;
            fact[i] = sum;
        }
        
        k--;
        
     StringBuilder res = new StringBuilder();
        
        
    for(int i = 1; i <= n; i++){
        int index = k/fact[n-i];
        res.append(String.valueOf(numbers.get(index)));
        numbers.remove(index);
        k -= index*fact[n-i];
     }
        
      
        return res.toString();
    }
}