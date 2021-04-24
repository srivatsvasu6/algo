class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int tank=0, total=0, start=0;
       
        for(int i=0; i<gas.length; i++) {
            int current = gas[i]-cost[i];
            tank += current;
            total += current;
            if(tank < 0) {
                start = i+1;
                tank = 0;
            }
        } 
        return total < 0 ? -1 : start;
        
    }
}