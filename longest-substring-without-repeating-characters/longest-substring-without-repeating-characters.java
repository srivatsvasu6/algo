class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        Set<Character> set = new HashSet<>();
        
        int l =0, r=0, end = s.length(), max = 0;
        
        while(r< end){
            
            char ch = s.charAt(r);
            
            if(!set.contains(ch)){
                
                max = Math.max(max, r - l +1);
                set.add(ch);
                r++;
            }else{
                
                set.remove(s.charAt(l++));
            }
            
        }
        return max;
        
    }
}