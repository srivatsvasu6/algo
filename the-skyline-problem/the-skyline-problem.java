class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        
        Building[] bb = new Building[2* buildings.length];
        int i =0;
        for(int[] x:  buildings){
            bb[i++] = new Building(x[0],true,x[2]);
        
            bb[i++] = new Building(x[1],false,x[2]);
        }
        Arrays.sort(bb);
        
        List<List<Integer>> res = new ArrayList<>();
        TreeMap<Integer, Integer> queue = new TreeMap<>();
        
        queue.put(0,1);
        int prevMax = 0;
        
        
        for(Building b: bb){
            
            if(b.start){
                queue.compute(b.height, (k,v)-> {
                    if(v != null){
                        return v+1;
                    }
                    return 1;
                });
            }else{
                queue.compute(b.height, (k,v)-> {
                    if(v == 1){
                        return null;
                    }
                    return v-1;
                });
                
            }
            
            int maxHeight = queue.lastKey();
            if(prevMax != maxHeight){
                prevMax = maxHeight;
                res.add(Arrays.asList(b.val,maxHeight) );
            }
        }
            
            return res;
        }
    
    static class Building implements Comparable<Building>{
        
        int val;
        boolean start;
    
        int height;
        
        public Building(int v, boolean s, int h){
            val = v;
            start = s;
            height = h;
        }
        
        @Override
        public int compareTo(Building o){
        
            
            if(this.val != o.val){
                return this.val - o.val;
            }else{
                return (this.start ? -this.height: this.height) -
                     (o.start ? - o.height: o.height);
            }
        }
        
        
    }
}