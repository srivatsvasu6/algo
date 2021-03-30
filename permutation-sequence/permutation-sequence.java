class Solution {
    
    public int fact(int n){
        if(n==0||n==1){
            return 1;
        }
        return n * fact(n-1);
    }
    
    public void findKthPermutation(List<Character> v, int k, StringBuilder result){
        if(v.isEmpty()){
            return;
        }
        
        int n = v.size();
        
        int count = fact(n-1);
        int selected = (k-1)/count;
        
        result.append(v.get(selected));
        v.remove(selected);
        k = k - count * selected;
        
        findKthPermutation(v, k, result);
    }
    
    public String getPermutation(int n, int k) {
        List<Character> v = new ArrayList<>();
       
        char c = '1';
        for(int i= 0; i<n; i++){
            v.add( c);
            c++;
        }
       StringBuilder res =    new StringBuilder();
        findKthPermutation(v, k, res);
        return res.toString();
    }
}