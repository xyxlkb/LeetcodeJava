import java.util.Stack;

public class lc1047_removeDuplicates {
    public static void main(String[] args) {
        Solution1047 so = new Solution1047();
        System.out.println(so.removeDuplicates("abbaca"));
    }
}
/*给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
在 S 上反复执行重复项删除操作，直到无法继续删除。
在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。*/
class Solution1047 {
    // 如果按题目说的一轮一轮清的话，可能需要很多很多轮，比如abcdeedcba 第一次ee，第二次dd这样
    // 但如果用栈就不一样了！每次入栈的时候检查一下是否和栈顶相同，相同则两个都丢弃abcdeedcba 丢弃ee之后，dd也会丢弃，这样一次就行！
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder res = new StringBuilder();
        for (int i=0; i<s.length(); i++) {
            if (!stack.isEmpty() && stack.peek()==s.charAt(i))  // 如果这个字母和前一个一样，就把前一个踢掉，cnt++
                stack.pop();
            else
                stack.add(s.charAt(i));
        }
        while (!stack.empty())
            res.append(stack.pop());
        return res.reverse().toString();
    }
}
