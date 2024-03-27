import javax.imageio.plugins.tiff.FaxTIFFTagSet;
import java.util.Stack;

public class lc20_isValid {
    public static void main(String[] args) {

    }
}

class Solution20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int len = s.length();
        for (int i=0; i<len; i++) {
            char ch = s.charAt(i);
            if (ch=='(' || ch=='[' || ch=='{')
                stack.add(ch);
            else if (stack.size() == 0) // 如果读到的是右括号，并且栈中没有东西了
                return false;
            else if (ch == ')') {
                if (stack.pop() != '(')
                    return false;
            }
            else if (ch == ']') {
                if (stack.pop() != '[')
                    return false;
            }
            else if (ch == '}') {
                if (stack.pop() != '{')
                    return false;
            }
        }
        if (stack.size() != 0)
            return false;
        return true;
    }
}
