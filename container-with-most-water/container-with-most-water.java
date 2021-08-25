class Solution {
    public int maxArea(int[] height) {
       
        int lo = 0, hi = height.length -1, lMax = 0, rMax =0;
        
        int maxArea = 0;
        while(lo < hi){
            
           maxArea = Math.max(maxArea, Math.min(height[lo] ,height[hi] ) * (hi - lo));
            
            if(height[lo] < height[hi] )
                lo++;
            else
                hi--;
           
        }
        
        return maxArea;
    }
}