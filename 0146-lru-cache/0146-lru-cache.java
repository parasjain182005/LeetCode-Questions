class Node{
    int key;
    int val;

    Node prev;
    Node next;

    Node(int key, int val){
        this.key=key;
        this.val=val;
    }
}
class LRUCache {

    Map<Integer, Node> map = new HashMap<>();
    int capacity;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity=capacity;
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            addToFront(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.val = value;
            remove(node);
            addToFront(node);
        }
        else{
            if(map.size() == capacity){
                Node temp = tail.prev;
                map.remove(temp.key);
                remove(temp);
            }
            Node node = new Node(key, value);
            map.put(key, node);
            addToFront(node);
        }
    }

    public void remove(Node node){
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    public void addToFront(Node node){
        Node temp = head.next;
        head.next = node;
        node.prev = head;
        node.next = temp;
        temp.prev = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */