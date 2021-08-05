class Solution {
    int maxLen = Integer.MIN_VALUE;
    public int maxLength(List<String> arr) {
       
        dfs(arr, 0, "");
        return maxLen;
    }
    
    public void dfs(List<String> arr, int index, String res){
         if (isValid(res)) maxLen = Math.max(maxLen, res.length());
        
        if (index == arr.size() || !isValid(res))  return;
        
        for(int i = index; i< arr.size(); i++){
            
            dfs(arr, i+1, res + arr.get(i));
        }
        
        
    }
    
    public boolean isValid(String str){
        
        int[] arr = new int[26];
        
        for(char c : str.toCharArray()){
            
            arr[c -'a']++;
            
            if(arr[c- 'a'] > 1){
                return false;
            }
        }
        
        return true;
    }
}