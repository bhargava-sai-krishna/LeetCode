class MyCircularDeque {
    public int[] queue;
    public int front, back, size, capacity;

    public MyCircularDeque(int k) {
        queue = new int[k];
        size = 0;
        front = 0;
        back = 0;
        capacity = k;
    }

    public boolean insertFront(int value) {
        if (isFull()){ 
            return false;
        }
        front = (front - 1 + capacity) % capacity;
        queue[front] = value;
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()){ 
            return false;
        }
        queue[back] = value;
        back = (back + 1) % capacity;
        size++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()){ 
            return false;
        }
        front = (front + 1) % capacity;
        size--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()){ 
            return false;
        }
        back = (back - 1 + capacity) % capacity;
        size--;
        return true;
    }

    public int getFront() {
        if (isEmpty()){ 
            return -1;
        }
        return queue[front];
    }

    public int getRear() {
        if (isEmpty()){
            return -1;
        }
        return queue[(back - 1 + capacity) % capacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
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