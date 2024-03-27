import java.util.LinkedList;
import java.util.Queue;

public class lc225_MyStack {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        System.out.println(myStack.empty());
    }
}

class MyStack {
    Queue<Integer> in;
    Queue<Integer> out;
    public MyStack() {
        in = new LinkedList<>();
        out = new LinkedList<>();
    }

    public void push(int x) {
        in.add(x);
    }

    public int pop() {
        while (in.size() > 1)
            out.add(in.remove());
        int res = in.remove();
        while (out.size() > 0)
            in.add(out.remove());
        return res;
    }

    public int top() {
        while (in.size() > 1)
            out.add(in.remove());
        int res = in.peek();
        out.add(in.remove());
        while (out.size() > 0)
            in.add(out.remove());
        return res;
    }

    public boolean empty() {
        return in.isEmpty();
    }
}
