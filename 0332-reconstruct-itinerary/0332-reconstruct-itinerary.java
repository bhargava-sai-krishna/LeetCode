class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> map= new HashMap<>();
        for(List<String> t:tickets){
            map.computeIfAbsent(t.get(0), k -> new PriorityQueue<>()).offer(t.get(1));
        }
        LinkedList<String> path=new LinkedList<>();
        dfs("JFK", map, path);
        return path;
    }
    private void dfs(String from, Map<String, PriorityQueue<String>> map, LinkedList<String> path){
        PriorityQueue<String> dest=map.get(from);
        while(dest!=null && !dest.isEmpty()){
            dfs(dest.poll(), map, path);
        }
        path.addFirst(from);
    }
}