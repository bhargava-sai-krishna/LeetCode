class Router {

    private int memoryLimit;
    private Map<Integer, List<Integer>> counts;
    private Map<Long, int[]> packets;
    private Queue<Long> q;
 
    public Router(int memoryLimit) {
        this.memoryLimit=memoryLimit;
        this.packets=new HashMap<>();
        this.counts=new HashMap<>();
        this.q=new LinkedList<>();
    }
    
    public boolean addPacket(int source, int destination, int timestamp) {
        long key=encode(source, destination, timestamp);
        if(packets.containsKey(key)){
            return false;
        }
        if(packets.size()>=memoryLimit){
            forwardPacket();
        }
        packets.put(key, new int[]{source, destination, timestamp});
        q.offer(key);
        counts.putIfAbsent(destination, new ArrayList<>());
        counts.get(destination).add(timestamp);
        return true;
    }
    
    public int[] forwardPacket() {
        if(packets.isEmpty()){
            return new int[]{};
        }
        long key=q.poll();
        int[] packet=packets.remove(key);
        if(packet==null){
            return new int[]{};
        }
        int destination=packet[1];
        List<Integer> list=counts.get(destination);
        list.remove(0);
        return packet;
    }
    
    public int getCount(int destination, int startTime, int endTime) {
        List<Integer> list=counts.get(destination);
        if(list==null || list.isEmpty()){
            return 0;
        }
        int left=lowerBound(list, startTime);
        int right=upperBound(list, endTime);
        return right-left;
    }
    public long encode(int source, int destination, int timestamp){
        return ((long)source << 40) | ((long)destination << 20) | timestamp;
    }
    public int lowerBound(List<Integer> list, int target){
        int low=0;
        int high=list.size();
        while(low<high){
            int mid=(low+high)>>>1;
            if(list.get(mid)<target){
                low=mid+1;
            }
            else{
                high=mid;
            }
        }
        return low;
    }
    public int upperBound(List<Integer> list, int target){
        int low=0, high=list.size();
        while(low<high){
            int mid=(low+high)>>>1;
            if(list.get(mid)<=target){
                low=mid+1;
            }
            else{
                high=mid;
            }
        }
        return low;
    }
}

/**
 * Your Router object will be instantiated and called as such:
 * Router obj = new Router(memoryLimit);
 * boolean param_1 = obj.addPacket(source,destination,timestamp);
 * int[] param_2 = obj.forwardPacket();
 * int param_3 = obj.getCount(destination,startTime,endTime);
 */