import java.util.*;

class FreqStack {
    private final Map<Integer, Integer> freq = new HashMap<>();              
    private final Map<Integer, Deque<Integer>> group = new HashMap<>();      
    private int maxFreq = 0;

    public FreqStack() {}

    public void push(int val) {
        int f = freq.getOrDefault(val, 0) + 1;
        freq.put(val, f);
        group.computeIfAbsent(f, k -> new ArrayDeque<>()).push(val);
        if (f > maxFreq) maxFreq = f;
    }

    public int pop() {
        Deque<Integer> stack = group.get(maxFreq);
        int val = stack.pop();
        freq.put(val, freq.get(val) - 1);
        if (stack.isEmpty()) {
            group.remove(maxFreq);   
            maxFreq--;
        }
        return val;
    }
}


/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */