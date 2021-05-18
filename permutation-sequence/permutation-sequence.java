class Solution {
    public String getPermutation(int n, int k) {
       
        int fact = 1;
        List<Integer> nums = new ArrayList<>();
       
        for(int i=1; i<n; i++){
            fact = fact * i;
            nums.add(i);
        }
           nums.add(n);
        
        StringBuilder sb = new StringBuilder();
        k=k-1;
        while(!nums.isEmpty()){
            
            sb.append(nums.get(k/fact));
            nums.remove(k/fact);
            if(nums.isEmpty()){
                break;
            }
            k = k%fact;
            fact = fact / nums.size();
            
        }
        
        return sb.toString();
        
        
    }
}