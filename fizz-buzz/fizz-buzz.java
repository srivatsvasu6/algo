class Solution {
    public List<String> fizzBuzz(int n) {
        String s= "";
        List<String> res = new ArrayList();
        for(int i=1; i<=n; i++){
            s= "";
      
            
            if(i%3 ==0 )
             s+= "Fizz";
            
            if( i%5 == 0)
               s+=  "Buzz";
            
            
             if(i%3 !=0 && i%5 != 0)
             s+=i;
                 
            res.add(s);
        }
        
        return res;
        
    }
}