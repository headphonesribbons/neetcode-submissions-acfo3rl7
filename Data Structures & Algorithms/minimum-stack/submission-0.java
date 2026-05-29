class MinStack {
    Stack<Integer> stack;
    PriorityQueue<Integer> queue;

    public MinStack() {
        this.stack = new Stack<>();
        this.queue = new PriorityQueue<>();
    }
    
    public void push(int val) {
        stack.push(val);
        queue.add(val);
    }
    
    public void pop() {
        Integer curr = stack.pop();
        queue.remove(curr);
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return queue.peek();
    }
}
