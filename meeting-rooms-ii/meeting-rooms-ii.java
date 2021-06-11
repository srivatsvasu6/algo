class Solution {
    public int minMeetingRooms(int[][] intervals) {
        
        
        int[] start = new int[intervals.length];
        
       int[] end = new int[intervals.length];
        int i =0;
        
        for(int[] interval : intervals){
            
            start[i] = interval[0];
            end[i] = interval[1];
            i++;
            
        }
        
        Arrays.sort(start);
        
        Arrays.sort(end);
        
        
int res = 0 , n = start.length, j = 0;
        
        i=0;
       while(i<n && j< n){
           
           if(start[i] >= end[j]){
          
               res--;
               j++;
           }
           i++;
           res++;
           
       }
        
        return res;
        
        
    }

    
}