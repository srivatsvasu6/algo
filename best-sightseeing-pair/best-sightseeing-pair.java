class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        
    int curr =0, res =0;
        
        for(int a: values){
            
            res = Math.max(res, a  + curr);
            curr = Math.max(curr, a) -1;
            
        }
        
        return res;
       
    }
}