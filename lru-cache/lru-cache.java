class LRUCache {

    int cap;
    int size;
    Map<Integer, Node> cache;
    DLList dll;

    public LRUCache(int capacity) {
        this.cap = capacity;
        this.size = 0;
        dll = new DLList();
        cache = new HashMap<>();

        
    }
    
    public int get(int key) {
        Node node = cache.get(key);
        if(node != null){
            dll.remove(node);
            dll.add(node);
            
           return node.val; 
        }
        return -1;
        
    }
    
    public void put(int key, int value) {
  
        
        Node node = cache.get(key);
        
        if(node==null){
        node = new Node(key, value);
        dll.add(node);
        cache.put(key, node);
            size ++;
        
        if(size > cap){
          Node rem =  dll.removeTail();
            cache.remove(rem.key);
            size--;
        }
        }else{
            
            dll.remove(node);
           
            node.val = value;
            dll.add(node);

       
       
    }
    }
    
    static class DLList{
        
        Node head;
        Node tail;
        
        public DLList(){
            
            this.head = new Node(0,0);
            this.tail = new Node(0,0);
            head.next = tail;
            tail.prev = head;
        }
        
        public void add(Node node){
            
          Node next =   head.next;
            head.next = node;
            node.next = next;
            next.prev = node;
            node.prev = head;

        }
        
        public void remove(Node node){
            
            node.prev.next = node.next;
            
            node.next.prev = node.prev;
        }
        
        public Node removeTail(){
            
            Node node = tail.prev;
            remove(node);
            return node;
        }
        
        
    }
    
    static class Node{
        
        int key, val;
        Node next;
        Node prev;
        
        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */