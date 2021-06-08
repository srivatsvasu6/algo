class Solution {
    public int maxNumberOfBalloons(String text) {
       
        int[] map = new int[26];
      
        
        for(char c: text.toCharArray()){
            map[c -'a'] ++;
        }
        
        return IntStream.of(
            map['b'-'a'],
            map['a'- 'a'], 
            map[('l'-'a')]/2,
            map[('o'-'a')]/2,
            map[('n'-'a')]
        ).min().getAsInt();
        
        
    }
}