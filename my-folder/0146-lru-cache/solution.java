class LRUCache {
    
    class ListNode {
        int key;
        int value;
        ListNode prev;
        ListNode next;
        
        ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    static class ListNodeUtil {
        static void insertAtHead(ListNode head, ListNode current) {
            current.next = head.next;
            head.next.prev = current;
            current.prev = head;
            head.next = current;
        }
        
        static void remove(ListNode current) {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
        
        static void update(ListNode head, ListNode current) {
            remove(current);
            insertAtHead(head, current);
        }
    }
    
    HashMap<Integer, ListNode> cache;
    int capacity;
    ListNode head;
    ListNode tail;

    public LRUCache(int capacity) {
        this.cache = new HashMap<Integer, ListNode>();
        this.capacity = capacity;
        this.head = new ListNode(-1, -1);
        this.tail = new ListNode(-1, -1);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }
    
    public int get(int key) {
        if(this.cache.get(key) == null) {
            return -1;
        }
        ListNode ret = this.cache.get(key);
        ListNodeUtil.update(this.head, ret);
        return ret.value;
    }
    
    public void put(int key, int value) {
        if(this.cache.get(key) != null) {
            ListNode node = this.cache.get(key);
            node.value = value;
            ListNodeUtil.update(this.head, node);
        } else {
            ListNode newNode = new ListNode(key, value);
            this.cache.put(key, newNode);
            ListNodeUtil.insertAtHead(this.head, newNode);
        }
        if(this.cache.size() > this.capacity) {
            ListNode last = this.tail.prev;
            ListNodeUtil.remove(last);
            this.cache.remove(last.key);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
