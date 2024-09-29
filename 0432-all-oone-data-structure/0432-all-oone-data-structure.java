import java.util.*;

class AllOne {
    public Map<String, Integer> map;
    public TreeMap<Integer, Set<String>> valueMap;

    public AllOne() {
        map = new HashMap<>();
        valueMap = new TreeMap<>();
    }

    public void inc(String key) {
        if (!map.containsKey(key)) {
            map.put(key, 1);
            valueMap.computeIfAbsent(1, k -> new HashSet<>()).add(key);
        } else {
            int currentValue = map.get(key);
            map.put(key, currentValue + 1);
            updateValueMap(key, currentValue, currentValue + 1);
        }
    }

    public void dec(String key) {
        if (map.containsKey(key)) {
            int currentValue = map.get(key);
            if (currentValue == 1) {
                map.remove(key);
                valueMap.get(1).remove(key);
                if (valueMap.get(1).isEmpty()) valueMap.remove(1);
            } else {
                map.put(key, currentValue - 1);
                updateValueMap(key, currentValue, currentValue - 1);
            }
        }
    }

    public String getMaxKey() {
        if (valueMap.isEmpty()) return "";
        return valueMap.lastEntry().getValue().iterator().next();
    }

    public String getMinKey() {
        if (valueMap.isEmpty()) return "";
        return valueMap.firstEntry().getValue().iterator().next();
    }

    public void updateValueMap(String key, int oldValue, int newValue) {
        valueMap.get(oldValue).remove(key);
        if (valueMap.get(oldValue).isEmpty()) {
            valueMap.remove(oldValue);
        }
        valueMap.computeIfAbsent(newValue, k -> new HashSet<>()).add(key);
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
