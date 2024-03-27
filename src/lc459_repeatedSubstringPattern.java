public class lc459_repeatedSubstringPattern {
    public static void main(String[] args) {
        Solution459 so = new Solution459();
//        System.out.println(so.strStr("ac", "ab"));
        System.out.println(so.repeatedSubstringPattern("abaababaab"));
    }
}
/*给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。
示例 1:
输入: s = "abab"
输出: true
解释: 可由子串 "ab" 重复两次构成。*/
class Solution459 {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        for (int i=1; i<=len/2; i++) {
            if (len%i != 0 ) // 要整数倍才行
                continue;

            String sub = s.substring(0,i); // 长度为i的子字符串
            boolean flag = true;
            for (int j=0; j<len; j++) { // 逐位比较
                if (s.charAt(j) != sub.charAt(j%i)) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                return true;
        }
        return false;
    }
}