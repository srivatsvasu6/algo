class LFUCache {
    int capacity;
    int size, min;

    Map<Integer, LLNode> nodeMap;
     Map<Integer, DLList> countMap;

    
    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        nodeMap = new HashMap<>();
        countMap = new HashMap<>();
        
       
    }
    
    
    public int get(int key) {
        
      LLNode node = nodeMap.get(key);
        if(node == null){
            return -1;
        }
        update(node);
        return node.value;
        
    }
    
    public void update(LLNode node){
        
        DLList oldList = countMap.get(node.cnt);
        oldList.remove(node);
        
         if (node.cnt == min && oldList.size == 0) min++; 
        
        node.cnt++;
        DLList newList = countMap.getOrDefault(node.cnt, new DLList());
        newList.add(node);
        countMap.put(node.cnt, newList);
    }
    
    public void put(int key, int value) {
        if(capacity ==0)
            return;
        
        LLNode node;
        if(nodeMap.containsKey(key)){
            node =nodeMap.get(key);
            node.value = value;
            
            update(node);
        }else{
            node = new LLNode(key, value);
            nodeMap.put(key, node);
            if (size == capacity) {
                DLList lastList = countMap.get(min);
                nodeMap.remove(lastList.removeLast().key);
                size--;
            }
            size++;
            min = 1;
            DLList newList = countMap.getOrDefault(node.cnt, new DLList());
            newList.add(node);
            countMap.put(node.cnt, newList);
        }
        
        
    }
    
    static class LLNode{
        int key, value, cnt;
        LLNode prev;
        LLNode next;
        public LLNode(int key, int value){
            this.key = key;
            this.value = value;
            this.cnt = 1;
        }
 
    }
    
   static class DLList{
        LLNode head;
       LLNode tail;
       int size;
        public DLList(){
            
           head = new LLNode(0,0);
           tail = new LLNode(0,0);
            head.next = tail;
            tail.prev = head;
        }
       
       public void add(LLNode node){
           
           head.next.prev =node;
           node.next = head.next;
           node.prev = head;
           head.next = node;
           
           size++;
           
           
       }
       
       public void remove(LLNode node){

          node.prev.next = node.next;
           node.next.prev = node.prev;
           size--;
       }
       
       public LLNode removeLast(){
           
           if(size > 0){
               
             LLNode node =   tail.prev;
               remove(node);
               return node;
           }
           return null;
       }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */