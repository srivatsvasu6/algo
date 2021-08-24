class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
  HashMap<Integer, Integer> m = new HashMap<>();
        
        for(int num : nums1){
            m.put(num, m.getOrDefault(num,0)+1);
        }
        int k = 0;
       
        for(int num: nums2){
             int cnt = m.getOrDefault(num, 0);
           if(cnt > 0){ 
               nums1[k++] = num;
               m.put(num, cnt -1 );
           }
        }
        
        return Arrays.copyOfRange(nums1, 0, k);
    }
}