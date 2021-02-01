package bug.free.broccoli.algoexpert;

public class MinMaxStackProgram {

    static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    static class MinMaxStack {
        Node top = null;
        Node max = null;
        Node min = null;

        MinMaxStack() {
        }

        public int peek() {
            return this.top == null ? -1 : this.top.value;
        }

        public int pop() {
            if (this.top == null || this.max == null || this.min == null) return -1;
            int v = this.top.value;
            this.top = this.top.next;
            boolean minChanged = v == this.min.value;
            boolean maxChanged = v == this.max.value;
            if (minChanged || maxChanged) {
                Node track = this.top;
                if(minChanged)
                    this.min = track;
                if(maxChanged)
                    this.max = track;
                if (track != null)
                    while (track.next != null) {
                        if (maxChanged && this.max.value < track.value) this.max = track;
                        if (minChanged && this.min.value > track.value) this.min = track;
                        track = track.next;
                    }
            }
            return v;
        }

        public void push(Integer number) {
            Node n = new Node(number);
            if (top != null) n.next = top;
            top = n;
            if (max == null) max = n;
            else if (n.value > max.value) max = n;
            if (min == null) min = n;
            else if (n.value < min.value) min = n;
        }

        public int getMin() {
            return this.min == null ? -1 : this.min.value;
        }

        public int getMax() {
            return this.max == null ? -1 : this.max.value;
        }
    }

    public static void main(String[] args) {

        MinMaxStack mms = new MinMaxStack();
        mms.push(2);
        mms.push(7);
        mms.push(1);
        mms.push(8);
        mms.push(3);
        mms.push(9);
        System.out.println(mms.getMin());
        System.out.println(mms.getMax());
        System.out.println(mms.peek());
        System.out.println(mms.pop());
        System.out.println(mms.getMin());
        System.out.println(mms.getMax());
        System.out.println(mms.peek());
        System.out.println(mms.pop());
        System.out.println(mms.getMin());
        System.out.println(mms.getMax());
        System.out.println(mms.peek());
        System.out.println(mms.pop());
        System.out.println(mms.getMin());
        System.out.println(mms.getMax());
        System.out.println(mms.peek());
        System.out.println(mms.pop());
        System.out.println(mms.getMin());
        System.out.println(mms.getMax());
        System.out.println(mms.peek());
        System.out.println(mms.pop());
        System.out.println(mms.getMin());
        System.out.println(mms.getMax());
        System.out.println(mms.peek());
        System.out.println(mms.pop());
        System.out.println(mms.getMin());
        System.out.println(mms.getMax());
        System.out.println(mms.peek());
        System.out.println(mms.pop());
        System.out.println(mms.getMin());
        System.out.println(mms.getMax());
        System.out.println(mms.peek());
        System.out.println(mms.pop());
        System.out.println(mms.getMin());
        System.out.println(mms.getMax());
        System.out.println(mms.peek());
        System.out.println(mms.pop());
        System.out.println(mms.getMin());
        System.out.println(mms.getMax());
        System.out.println(mms.peek());
    }

}
