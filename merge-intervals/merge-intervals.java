class Solution {
    public int[][] merge(int[][] intervals) {
        
        if(intervals==null || intervals.length<2){
            return intervals;
        }
        
        Arrays.sort(intervals, Comparator.comparingInt(a->a[0]));
      int[][] res = new int[intervals.length][2];
        int start = intervals[0][0], end = intervals[0][1], idx =0;
        
        for(int i=1; i< intervals.length; i++){
            
            if(intervals[i][0] <= end){
                
                end = Math.max(end,intervals[i][1] );
                
            }else{
                res[idx++] = new int[]{start, end};
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        
       res[idx++] = new int[]{start, end};
        
        return Arrays.copyOfRange(res, 0, idx);
    }
}