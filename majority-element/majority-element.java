class Solution {
    public int majorityElement(int[] nums) {
       int count =0, el = 0;
      
        for (int i=0; i< nums.length; i++) {
            if (count == 0) {
                el = nums[i];
            }
            count += (nums[i] == el) ? 1 : -1;
        }
        
        
        return el;
    }
}