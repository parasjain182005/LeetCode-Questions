class Node{
    int val;
    Node next;

    Node(int val){
        this.val = val;
    }
}
class MyLinkedList {
    Node head;
    int size;

    public MyLinkedList() {
        head = null;
        size = 0;
    }
    
    public int get(int index) {
        if(index >= size) return -1;
        Node temp = head;
        for(int i=0; i<index; i++){
            temp = temp.next;
        }
        return temp.val;
    }
    
    public void addAtHead(int val) {
        Node temp = new Node(val);
        temp.next = head;
        head = temp;
        size++;
    }
    
    public void addAtTail(int val) {
        if(head == null) {
            addAtHead(val);
            return;
        }
        
        Node temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        Node x = new Node(val);
        temp.next = x;
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        if(index == 0){
            addAtHead(val);
            return;
        }
        if(index == size){
            addAtTail(val);
            return;
        }

        Node temp = head;
        for(int i=0; i<index-1; i++){
            temp = temp.next;
        }

        Node x = temp.next;
        Node y = new Node(val);
        temp.next = y;
        y.next = x;
        size++;
    }
    
    public void deleteAtIndex(int index) {
        if(index == size) return;
        if(index == 0) {
            head = head.next;
            size--;
            return;
        }
        Node temp = head;
        for(int i=0; i<index-1; i++){
            temp = temp.next;
        }
        temp.next = temp.next.next;
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */