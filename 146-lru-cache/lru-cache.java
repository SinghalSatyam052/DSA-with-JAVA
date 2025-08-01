class LRUCache {

    class Node{
        int val;
        int key;
        Node prev;
        Node next;

        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    Node head = new Node(-1,-1);
    Node tail = new Node(-1,-1);
    int cap;
    HashMap<Integer,Node> map = new HashMap<>();

    public LRUCache(int capacity) {
        cap = capacity;
        head.next = tail;
        tail.prev = head;
    }

    private void addNode(Node newNode){
        Node temp = head.next;

        newNode.next = temp;
        newNode.prev = head;

        head.next = newNode;
        temp.prev = newNode;
    }

    private void delNode(Node newNode){

        Node prev = newNode.prev;
        Node next = newNode.next;

        prev.next = next;
        next.prev = prev;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node res = map.get(key);

            map.remove(key);
            delNode(res);
            addNode(res);

            map.put(key,head.next);

            return res.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node curr = map.get(key);
            map.remove(key);
            
            delNode(curr);
        }

        if(map.size() == cap){
            map.remove(tail.prev.key);
            delNode(tail.prev);
        }
        addNode(new Node(key,value));
        map.put(key,head.next);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */