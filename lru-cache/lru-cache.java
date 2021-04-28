class LRUCache {
private int count;
private int capacity;
private DLinkedNode head, tail;
    
 class DLinkedNode{
        
        DLinkedNode pre ;
        DLinkedNode next;
        int val;
        int key;
    }
    
/**
 * Always add the new node right after head;
 */
    private void addNode(DLinkedNode node) {
        
        node.pre = head;
        node.next = head.next;
        
        head.next.pre = node;
        head.next = node;
        
    }
    
/**
 * Remove an existing node from the linked list.
 */
private void removeNode(DLinkedNode node){
    
    node.pre.next = node.next;
    node.next.pre = node.pre;
    
    
}
    
    /**
     * Move certain node in between to the head.
     */
    private void moveToHead(DLinkedNode node){
      this.removeNode(node);
      this.addNode(node);
    }

// pop the current tail. 
    private DLinkedNode popTail(){
      DLinkedNode res = tail.pre;
      this.removeNode(res);
      return res;
    }

    
private Map<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();
    
    

    public LRUCache(int capacity) {
        
  this.count = 0;
  this.capacity = capacity;
        
   head = new DLinkedNode();
   head.pre = null;
   tail = new DLinkedNode();   
   tail.next = null;
        
    head.next = tail;
    tail.pre = head;
        
    }
    
    public int get(int key) {
        
        if(cache.get(key) ==null){
            return -1;
        }
        
        DLinkedNode node = cache.get(key);
        
        this.moveToHead(node);
        
        return node.val;
        
    }
    
    public void put(int key, int value) {
        
       DLinkedNode node = cache.get(key);
         if( node ==null){
             node = new DLinkedNode();
             
             node.key = key;
             node.val = value;
             
             this.addNode(node);
             cache.put(key, node);
             count++;
             
             if(count > capacity){
                 
                DLinkedNode tt = this.popTail(); 
                
                 this.cache.remove(tt.key);
                 count--;
             }
             
             
             
         }else{
             
             node.val = value;
             this.moveToHead(node);
         }
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */