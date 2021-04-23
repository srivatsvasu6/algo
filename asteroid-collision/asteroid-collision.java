class Solution {
    public int[] asteroidCollision(int[] asteroids) {
    int last = 0;
        int curr = 1;
        
        while (curr < asteroids.length) {        
            if ((last >= 0) && (asteroids[last] > 0) && (asteroids[curr] < 0)) {
                if (-asteroids[curr] > asteroids[last]) {
                    last--;
                } else if (-asteroids[curr] < asteroids[last]) {
                    curr++;
                } else {
                    last--;
                    curr++;
                }
            } else {
                asteroids[++last] = asteroids[curr++];
            }            
        }
      
        return Arrays.copyOfRange(asteroids, 0, ++last);
        
        
    }
}