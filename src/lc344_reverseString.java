public class lc344_reverseString {
    public static void main(String[] args) {
        String s = "hello";
        Solution344 so = new Solution344();
        so.reverseString(s.toCharArray());

    }
}
/*编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。*/
class Solution344 {
    public void reverseString(char[] s) {
        int len = s.length;
        int left = 0;
        int right = len-1;
        while(left < right) {
            char ch = s[left];
            s[left] = s[right];
            s[right] = ch;
            left++;
            right--;
        }
//        System.out.println(s);
    }
}
