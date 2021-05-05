class Solution {
    public List<Integer> partitionLabels(String S) {
        int[] freq = new int[26];
        for(int i=0; i<S.length(); i++){
            freq[S.charAt(i)-'a'] = i;
        }
        
        List<Integer> ls = new ArrayList();
        
        int run =0, max=0;
        for(int i=0; i<S.length(); i++){
            
            max = Math.max(max, freq[S.charAt(i)-'a']);
            
            if(max ==i){
                ls.add(i - run +1);
                run = i+ 1;
            }
        }
        return ls;
    }
}