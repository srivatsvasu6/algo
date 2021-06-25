class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
   List<Integer> ls = new ArrayList<>();
        
        for(int a : arr){
            ls.add(a);
        }
        Collections.sort(ls, (a,b) -> {

            if( Math.abs(a - x) ==  Math.abs(b- x)){
                return Integer.compare(a,b);
            }else{
                return Integer.compare( Math.abs(a-x), Math.abs(b-x));
            }
        });
        
        List<Integer> res = ls.subList(0, k);
        
        Collections.sort(res);
        return res;
    }
        
}