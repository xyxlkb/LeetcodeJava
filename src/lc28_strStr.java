public class lc28_strStr {
    public static void main(String[] args) {
        Solution28 so = new Solution28();
        System.out.println(so.strStr("leetcode", "code"));
    }
}

class Solution28 {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0; // 如果needle为空，则返回0
        int[] next = getNextArray(needle);
        int i = 0, j = 0;
        while (i < haystack.length() && j < needle.length()) {
            if (j == -1 || haystack.charAt(i) == needle.charAt(j)) { // 匹配成功或者重新开始匹配,j=-1就是重新开始匹配，单独处理
                i++; // j=-1的时候意味着needle第0位就不匹配，要用haytack的下一位和needle第0位比较了，所以i++ j++
                j++;
            } else {
                j = next[j]; // 失配时根据next数组移动j指针
            }
        }
        if (j == needle.length()) {
            return i - j; // 返回匹配到的起始位置
        } else {
            return -1; // 没有匹配成功，返回-1
        }
    }

    /*找next数组
    a  a b a b c a a b
    a  a b a a c
    -1 0 1 0 1 2
    * */
    public int[] getNextArray(String s) {
        int[] next = new int[s.length()];
        next[0] = -1; // 第0位的next一定是-1，因为第0位失配了needle要前进一位比较，相当于用-1位和当前位比较
        int i = 0, j = -1;
        while (i < s.length() - 1) { // 求后面每一位的next
            if (j == -1 || s.charAt(i) == s.charAt(j)) { // 每一位的next可能是上一位+1.或者重新开始计算
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
        return next;
    }
}

