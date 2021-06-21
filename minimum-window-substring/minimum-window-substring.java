class Solution {
    public String minWindow(String s, String t) {
        
        if (s.length() == 0 || t.length() == 0) {
          return "";
      }
        
        if(s.equals(t)){
            return s;
        }
        
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> windowCounts = new HashMap<>();
        for(char c: t.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }
         int required = map.size();
        int matched = 0, l =0, r=0, min = s.length()+1, sub = 0;
        
        
          // ans list of the form (window length, left, right)
      int[] ans = {-1, 0, 0};

      while (r < s.length()) {
          // Add one character from the right to the window
          char c = s.charAt(r);
          int count = windowCounts.getOrDefault(c, 0);
          windowCounts.put(c, count + 1);

          // If the frequency of the current character added equals to the
          // desired count in t then increment the formed count by 1.
          if (map.containsKey(c) && windowCounts.get(c).intValue() == map.get(c).intValue()) {
              matched++;
          }

          // Try and contract the window till the point where it ceases to be 'desirable'.
          while (l <= r && matched == required) {
              c = s.charAt(l);
              // Save the smallest window until now.
              if (ans[0] == -1 || r - l + 1 < ans[0]) {
                  ans[0] = r - l + 1;
                  ans[1] = l;
                  ans[2] = r;
              }

              // The character at the position pointed by the
              // `Left` pointer is no longer a part of the window.
              windowCounts.put(c, windowCounts.get(c) - 1);
              if (map.containsKey(c) && windowCounts.get(c).intValue() < map.get(c).intValue()) {
                  matched--;
              }

              // Move the left pointer ahead, this would help to look for a new window.
              l++;
          }

          // Keep expanding the window once we are done contracting.
          r++;   
      } return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);   
    }
}