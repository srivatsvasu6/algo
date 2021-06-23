/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
class Solution {
    public void findSecretWord(String[] wordList, Master master) {
       
        
       for(int k=0, x = 0; k< 10 && x< 6 ; k++) {
          int[][] count = new int[6][26];
        int best = 0;
        for(String w1: wordList){
           
            for(int i = 0; i<6; i++){
                char c = w1.charAt(i);
                count[i][c -'a']++;
            }
        }

        String guess = wordList[0];
         for(String w1: wordList){
            int score = 0;
            for (int i = 0; i < 6; ++i)
                score += count[i][w1.charAt(i) - 'a'];
                
                if (score > best) {
                    guess = w1;
                    best = score;
                }
         }
        
        x = master.guess(guess);
           
        List<String> wordlist2 = new ArrayList<String>();
        for(String w1: wordList){
            
            if(distance(w1,guess)==x){
                wordlist2.add(w1);
            }
        }
        System.out.println(wordlist2);
        wordList = wordlist2.toArray( new String[0]);
       
       }

    }
    
    public int distance(String s1, String s2){
        
        if(s1.length() !=s2.length())
            return -2;
        
        int match =0;
        
        for(int i=0; i<s1.length(); i++){
            if(s1.charAt(i) == s2.charAt(i))
               match++; 
        }
        
        return match;
    }
    
    
}