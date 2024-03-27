import java.util.Stack;

public class lc232_MyQueue {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.pop());
    }
}
/*请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：*/
class MyQueue {
    Stack<Integer> in;
    Stack<Integer> out;
    public MyQueue() { // 构造函数，新建两个栈
        in = new Stack<>(); // 这里直接用in  而不是重新声明一次in， 否则它就变成局部变量了！
        out = new Stack<>();
    }

    public void push(int x) {
        in.push(x);
    }

    public int pop() {
        while (!in.empty())
            out.push(in.pop());
        int res = out.pop();
        while (!out.empty())
            in.push(out.pop());
        return res;
    }

    public int peek() {
        while (!in.empty())
            out.push(in.pop());
        int res = out.peek();
        while (!out.empty())
            in.push(out.pop());
        return res;
    }

    public boolean empty() {
        return in.empty();
    }
}