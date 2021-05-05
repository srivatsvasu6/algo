class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        int l = nums1.length;
        int m = nums2.length;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int end =0, i=0,j=0, prev=-1;
        int[] res = new int[Math.min(l,m)];
        
        while(i<l && j<m){
            
            if(nums1[i] < nums2[j]){
                i++;
            }else if(nums1[i] > nums2[j]){
                j++;
            }else {
              if(prev!=nums1[i])
                res[end++] = nums1[i];
                
                prev = nums1[i];
                i++;
                j++;
            }
            
        }
        
        return Arrays.copyOfRange(res, 0, end);
    }
}