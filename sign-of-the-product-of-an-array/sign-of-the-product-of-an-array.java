class Solution {
    public int arraySign(int[] nums) {
        int sign= 0;
        for(int num: nums){
            if(num<0){
                sign ++; 
            }else if(num ==0){
                return 0;
            }
        }
        return sign %2==0?1:-1;
    }
}