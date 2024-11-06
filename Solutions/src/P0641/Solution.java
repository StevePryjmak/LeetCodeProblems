package P0641;

class MyCircularDeque {
    private int maxSize;
    private int currSize = 0;
    Node front, back;
    private class Node {
        int value; 
        Node next;
        Node prev;
        Node (int value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    public MyCircularDeque(int k) {
        maxSize = k;
        front = null;
        back = null;
    }
    
    public boolean insertFront(int value) {
        if(isFull()) return false;
        
        Node node = new Node(value, front, back);
        if(isEmpty()) return insertFirstElement(node);
        front.prev = node;
        front = front.prev;
        currSize++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if(isFull()) return false;
        
        Node node = new Node(value, front, back);
        if(isEmpty()) return insertFirstElement(node);
        back.next = node;
        back = back.next;
        currSize++;
        return true;
    }

    //Helper function
    public boolean insertFirstElement(Node node) {
        front = node;
        back = node;
        front.next = front;
        front.prev = front;
        currSize++;
        return true;
    }
    
    public boolean deleteFront() {
        if(isEmpty()) return false;
        currSize--;
        if(isEmpty())  return Empty();

        front = front.next;
        front.prev = back;
        back.next = front;
        return true;
    }
    
    public boolean deleteLast() {
        if(isEmpty()) return false;
        currSize--;
        if(isEmpty())  return Empty();
            
        back = back.prev;
        back.next = front;
        front.prev = back;
        return true;
    }

    //Helper function 
    public boolean Empty() {
        front = null;
        back = null;
        return true;
    }
    
    public int getFront() {
        if(front == null) return -1;
        return front.value;
    }
    
    public int getRear() {
        if(back == null) return -1;
        return back.value;
    }
    
    public boolean isEmpty() {
        return currSize == 0;
    }
    
    public boolean isFull() {
        return currSize == maxSize;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */