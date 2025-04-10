public CustomStack(int size) {
        this.data = new int[size];
    }

    public CustomStack() {
        this.data = new int[10];
    }

    public boolean push(int iteam) {
        ++this.ptr;
        if (this.ptr >= this.data.length) {
            System.out.println("stack is full");
            return false;
        } else {
            this.data[this.ptr] = iteam;
            return true;
        }
    }

    public boolean pop() {
        if (this.ptr < 0) {
            System.out.println("empety stack");
            return false;
        } else {
            int removed = this.data[this.ptr];
            System.out.println("removed-->" + removed);
            --this.ptr;
            return true;
        }
    }

    public int peek() {
        return this.data[this.ptr];
    }

    public void increment(int k, int val) {
        for(int i = 0; i < this.data.length; ++i) {
            if (this.ptr < 0) {
                System.out.println("empety stack");
                return;
            }

            int top = this.data[this.ptr];
            this.stack2.add(top);
            --this.ptr;
        }

        for(int i = 0; i < k; ++i) {
            ++this.ptr;
            int top = (Integer)this.stack2.pop();
            top += val;
            this.data[this.ptr] = top;
        }
}

    

    public void display() {
        for(int i = 0; i < this.data.length; ++i) {
            int var10001 = this.data[i];
            System.out.print(var10001 + "->");
        }

        System.out.println("end");
    }
}


