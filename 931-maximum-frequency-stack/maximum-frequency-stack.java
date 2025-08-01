class FreqStack {

    Map<Integer,Integer> freq;
    Map<Integer,Stack<Integer>> map;
    int maxFreq;


    public FreqStack() {
        freq = new HashMap<>();
        map  = new HashMap<>();
        maxFreq = 0;
    }
    
    public void push(int val) {
        int currFreq = freq.getOrDefault(val,0);
        freq.put(val,currFreq+1); 
        if(!map.containsKey(currFreq)) map.put(currFreq,new Stack<>());
        map.get(currFreq).push(val);
        maxFreq = Math.max(currFreq,maxFreq);
    }
    
    public int pop() {
        int res = map.get(maxFreq).pop();
        freq.put(res,freq.get(res)-1);
        if(map.get(maxFreq).isEmpty()) maxFreq--;
        return res;        
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */