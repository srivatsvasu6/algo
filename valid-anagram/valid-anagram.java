class Solution {
    public boolean isAnagram(String s, String t) {
        
        int[] res = new int[26];
        
        for(char c: s.toCharArray()){
            res[c-'a']++;
        }
        
        for(char c : t.toCharArray()){
         
            if(res[c - 'a'] > 0){
                res[c-'a']--;
            }else
                return false;
        }
        
        for(int i =0; i< 26; i++){
            if(res[i] !=0)
                return false;
        }
        
        return true;
    }
}