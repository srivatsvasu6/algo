class Solution {
    public int trap(int[] height) {
        
        
        int l = 0, r= height.length-1, lm=0, rm = 0, res =0;
        
        
        while(l< r){
            
            if(height[l]< height[r]){
                lm = Math.max(lm, height[l]);
                
                res += lm - height[l];
                l++;
                
            }else{
                  rm = Math.max(rm, height[r]);
                
                res += rm - height[r];
                r--;
                
            }
            
        }
        
        return res;
    }
}