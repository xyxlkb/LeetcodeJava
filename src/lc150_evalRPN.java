import javax.swing.*;
import java.io.FileFilter;
import java.util.Stack;

public class lc150_evalRPN {
    public static void main(String[] args) {
        String[] tokens = {"2","1","+","3","*"};
        Solution150 so = new Solution150();
        System.out.println(so.evalRPN(tokens));
    }
}

class Solution150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> numStack = new Stack<>();
        for (int i=0; i<tokens.length; i++) {
            if (isNumber(tokens[i])) // 数字直接加入数字栈
                numStack.push(Integer.parseInt(tokens[i]));
            else {
                int secNum = numStack.pop();
                int firNum = numStack.pop();
                if (tokens[i].equals("+"))
                    numStack.push(firNum + secNum);
                else if (tokens[i].equals("-"))
                    numStack.push(firNum - secNum);
                else if (tokens[i].equals("*"))
                    numStack.push(firNum * secNum);
                else if (tokens[i].equals("/"))
                    numStack.push(firNum / secNum);
            }
        }
        return numStack.pop();
    }

    public boolean isNumber(String str) { // 判断一个字符串是否全部是数字
        if (str.charAt(0)=='-' && str.length()==1)
            return false;
        if (!Character.isDigit(str.charAt(0)) && str.charAt(0)!='-') // 第一位可能是负号或者数字，单独处理
            return false;
        for (int i=1; i<str.length(); i++) {
            if (!Character.isDigit(str.charAt(i)))
                return false;
        }
        return true;
    }
}
