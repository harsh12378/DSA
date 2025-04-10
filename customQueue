class MyQueue {
    Stack<Integer> first = new Stack();
    Stack<Integer> second = new Stack();

    public MyQueue() {
    }

    public void push(int x) {
        this.first.push(x);
    }

    public int pop() {
        while(!this.first.empty()) {
            this.second.push((Integer)this.first.pop());
        }

        int removed = (Integer)this.second.pop();

        while(!this.second.empty()) {
            this.first.push((Integer)this.second.pop());
        }

        return removed;
    }

    public int peek() {
        while(!this.first.empty()) {
            this.second.push((Integer)this.first.pop());
        }

        int top = (Integer)this.second.peek();

        while(!this.second.empty()) {
            this.first.push((Integer)this.second.pop());
        }

        return top;
    }

    public boolean empty() {
        return this.first.empty();
    }
}
