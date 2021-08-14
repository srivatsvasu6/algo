class MyHashMap {

    List<int[]>[] list;
    int size = 10001;
    /** Initialize your data structure here. */
    public MyHashMap() {
        list = new ArrayList[size];
        
      
    }
    private int idx(int key){
        return key % size;
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hash = idx(key);
        if(list[hash] == null){
          list[hash] = new ArrayList<>();  
        }
         for(int i=0; i<list[hash].size(); i++)
        {
            if(list[hash].get(i)[0]==key)
            {
                list[hash].get(i)[1]=value;
                return;
            }
        }
        
        list[hash].add(new int[]{key, value});
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hash = idx(key);
        if(list[hash] == null){
            return -1;
        }
         for(int i=0; i<list[hash].size(); i++)
        {
            if(list[hash].get(i)[0]==key)
            {
                return list[hash].get(i)[1];
            
            }
        }
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hash = idx(key);
        if(list[hash] == null){
            return;
        }
          for(int i=0; i<list[hash].size(); i++)
        {
           int[] entry = list[hash].get(i);
            if(entry[0]==key)
            {
                list[hash].remove(entry);
                return;
            
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */