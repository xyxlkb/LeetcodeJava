public class lc151_reverseWords {
    public static void main(String[] args) {
        Solution151 so = new Solution151();
        String s = "the sky is blue";
//        System.out.print(so.removespaces(s));
        System.out.println(so.reverseWords(s));
    }
}
/*示例 1：
输入：s = "the sky is blue"
输出："blue is sky the"
示例 2：
输入：s = "  hello world  "
输出："world hello"
解释：反转后的字符串中不能存在前导空格和尾随空格。
示例 3：
输入：s = "a good   example"
输出："example good a"
解释：如果两个单词间有多余的空格，反转后的字符串需要将单词间的空格减少到仅有一个。*/
class Solution151 {
    public String reverseWords(String s) {
        s = removespaces(s); // 去除前后空格，把多个空格变成一个
        char[] res = s.toCharArray(); // 后面全程用数组操作，方便
        res = reverseLeftToRight(res,0,s.length()-1); // 先把s整个反转，然后把每个单词反转
        int left = 0;
        int right = 0;
        while (right < res.length) {
            while (right<res.length && res[right] != ' ')
                right++;
            reverseLeftToRight(res, left, right-1);
            left = right+1;
            right++;
        }

        return String.valueOf(res);
//        下面使用split方法写的，不用内置方法写一次
//        String[] items = removespaces(s).split(" ");
//        StringBuilder res = new StringBuilder();
//        int n = items.length;
//        for (int i=n-1; i>0; i--) {
//            res.append(items[i]);
//            res.append(" ");
//        }
//        res.append(items[0]);
//        return res.toString();
    }

    public static char[] reverseLeftToRight(char[] chars, int left, int right) { // 从left到right的范围内反转 左右都包
        if (left<0 || right>chars.length-1)
            return chars;
        while (left < right) {
            char ch = chars[left];
            chars[left] = chars[right];
            chars[right] = ch;
            left++;
            right--;
        }

        return chars;
    }

    public static String removespaces(String s) { // 去除开头和结尾的空格，连续的空格变成一个
        StringBuilder res = new StringBuilder();
        int left=0;
        while (s.charAt(left) == ' ' && left<s.length())
            left++;
        int right = s.length()-1;
        while (s.charAt(right) == ' ' && right>0)
            right--;
        while (left <= right) {
            if (left>0 && s.charAt(left)==s.charAt(left-1) && s.charAt(left)==' ')
                left++;
            else {
                res.append(s.charAt(left));
                left++;
            }
        }
        return res.toString();
    }
}
