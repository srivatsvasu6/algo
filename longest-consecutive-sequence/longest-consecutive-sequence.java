class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = 0, cnt = 0, num = 0;
        for(int a: nums){
            set.add(a);
        }
        
        for(int a : nums){
            
            cnt = 0;
            num = a;
            if(!set.contains(num-1)){
                
                while(set.contains(num)){
                    cnt++;
                    num++;
                }
            max = Math.max(max, cnt);
            }
           
        }
        
        return max;
    }
}