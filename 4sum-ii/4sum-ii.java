class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        
        return kSumCount(new int[][]{nums1,nums2, nums3,nums4});
        
        
    }
    
    public int kSumCount( int[][] lists){
        Map<Integer,Integer> m = new HashMap<>();
        
        countHalf(m, lists, 0, 0);
        
        return countComplements( m,lists, lists.length/2, 0);
    }
    
    
    private void countHalf( Map<Integer,Integer> m  ,int[][] lists , int i, int sum ){
        
        if(i == lists.length/2){
            m.put(sum, m.getOrDefault(sum,0)+1);
        }else
            for(int a: lists[i])
                countHalf(m, lists,i+1, sum + a);  
    }
    
    
    private int countComplements( Map<Integer,Integer> m  ,int[][] lists , int i, int complement ){
        int cnt = 0;
        if(i == lists.length){
            return m.getOrDefault(complement, 0);
        }else
            for(int a: lists[i])
            cnt += countComplements(m, lists, i+1, complement - a);
        return cnt;
    }
}