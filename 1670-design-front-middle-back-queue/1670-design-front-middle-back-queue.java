class Node{
    int val;

    Node prev;
    Node next;

    Node(int val){
        this.val = val;
    }
}
class FrontMiddleBackQueue {
    Node head;
    Node tail;
    int size;

    public FrontMiddleBackQueue() {
        head = new Node(0);
        tail = new Node(0);
        size = 0;
        head.next = tail;
        tail.prev = head;
    }
    
    public void pushFront(int val) {
        Node x = new Node(val);
        
        x.next = head.next;
        head.next = x;
        x.next.prev = x;
        x.prev = head;
        size++;
    }
    
    public void pushMiddle(int val) {
        Node temp = head;

        for(int i=0; i<size/2; i++){
            temp = temp.next;
        }

        Node x = new Node(val);        
        x.next = temp.next;
        temp.next = x;
        x.next.prev = x;
        x.prev = temp;
        size++;

    }
    
    public void pushBack(int val) {
        Node x = new Node(val);
        
        x.prev = tail.prev;
        x.next = tail;
        tail.prev = x;
        x.prev.next = x;
        size++;
    }
    
    public int popFront() {
        if(size>0){
            int x = head.next.val;
            head.next = head.next.next;
            head.next.prev = head;
            size--;
            return x;
        }
        return -1;
    }
    
    public int popMiddle() {
        if(size<1) return -1;
        Node temp = head;

        for(int i=0; i<(size-1)/2; i++){
            temp = temp.next;
        }
     
        int x = temp.next.val;
        temp.next = temp.next.next;
        temp.next.prev = temp;
        size--;
        return x;
    }
    
    public int popBack() {
        if(size>0){
            int x = tail.prev.val;
            tail.prev = tail.prev.prev;
            tail.prev.next = tail;
            size--;
            return x;
        }
        return -1;
    }
}

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */