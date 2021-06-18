class Solution {
    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        
        
        
        int i =0, res = 0;
        
        while(i<s.length()){
            
        String curr = s.substring(i, i +1);
        int currVal = map.get(curr);
            int nextVal =0;
            if(i+1< s.length()){
                String next = s.substring(i+1, i+2);
                nextVal = map.get(next);
            }
            
            if(currVal < nextVal){
                
                res += (nextVal - currVal);
                
                i +=2;
            }else{
                res += currVal;
                i++;
            }
            
            
        }
        
        return res;
        
        
    }
}