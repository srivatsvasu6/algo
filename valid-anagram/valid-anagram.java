class Solution {
    public boolean isAnagram(String s, String t) {
        
        
        int[] dict = new int[26];
        
        for(char c: s.toCharArray())
            dict[c-'a']++;
        
         for(char c: t.toCharArray())
            dict[c-'a']--;
        
        for(int n: dict){
            if(n !=0){
                return false;
            }
        }
        
        return true;
    }
}