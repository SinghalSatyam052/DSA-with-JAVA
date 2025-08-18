class MinStack {
    Stack<Integer> stk;
    Stack<Integer> s;

    public MinStack() {
        stk = new Stack<>();
        s = new Stack<>();
    }
    
    public void push(int val) {
        stk.push(val);
        if(s.isEmpty() || s.peek() >= val) s.push(val);
    }
    
    public void pop() {
        if(stk.peek().equals(s.peek())) s.pop();
        stk.pop();
    }
    
    public int top() {
        return stk.isEmpty() ? -1 : stk.peek();
    }
    
    public int getMin() {        
        return s.isEmpty() ? -1 : s.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */