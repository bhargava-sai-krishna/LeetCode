class LRUCache {
    Map<Integer, Integer> map;
    int capacity;
    List<Integer> list;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map =new  HashMap<>();
        list = new LinkedList<>();
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }

        list.remove(Integer.valueOf(key));
        list.addLast(key);
        return map.get(key);
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            list.remove(Integer.valueOf(key));
        }
        else if(map.size() == capacity) {
            int toBeRemoved = list.removeFirst();
            map.remove(toBeRemoved);
        }
        list.addLast(key);
        map.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */