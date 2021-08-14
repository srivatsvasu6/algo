/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    int n;
    public int findCelebrity(int n) {
        this.n = n;
        int celeb = 0;
        for(int i = 0; i<n; i++){
            
            if(knows(celeb, i)){
                celeb = i;
            }
        }
        return isCeleb(celeb) ? celeb : -1;
        
    }
    
    public boolean isCeleb(int i){
        
        for(int j = 0; j< n ; j++){
            if(i==j)
                continue;
            
            if(knows(i, j) || !knows(j, i)){
                return false;
            }
        }
        return true;
    }
}