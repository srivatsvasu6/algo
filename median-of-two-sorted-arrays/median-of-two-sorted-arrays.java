class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
       
        
        int[] aShort = nums1;
        int[] aLong = nums2;
        
        if(aShort.length > aLong.length){ 
            aShort= nums2;
            aLong = nums1;
         }
        
        
      int  l=0, r=aShort.length, mid;
      
        int x = aShort.length;
        int y = aLong.length;
        
        while(l <= r){
          
           int px = (l + r)/2;
            
           int py = (x+y +1)/2 - px;
            
           
            int maxLeftX = (px == 0) ? Integer.MIN_VALUE : aShort[px - 1];
            int minRightX = (px == x) ? Integer.MAX_VALUE : aShort[px];

            int maxLeftY = (py == 0) ? Integer.MIN_VALUE : aLong[py - 1];
            int minRightY = (py == y) ? Integer.MAX_VALUE : aLong[py];
            
            if(maxLeftX <= minRightY && maxLeftY <= minRightX ){
                
              if ((x + y) % 2 == 0) {
                    return ((double) Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))/2;
                } else {
                    return (double) Math.max(maxLeftX, maxLeftY);
                }
            }else if( maxLeftX > minRightY ){
                r  = px -1;
            }else{
                l = px + 1;
            }
            
        }
        
        return 0;
        
    }

    
}