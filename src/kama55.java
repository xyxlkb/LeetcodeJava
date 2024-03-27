public class kama55 {
    public static void main(String[] args) {
        String s = "abcdefg";
        solutionmaka55 so = new solutionmaka55();
        System.out.println(so.rightReverseString(s,2));

    }
}
/*字符串的右旋转操作是把字符串尾部的若干个字符转移到字符串的前面。
给定一个字符串 s 和一个正整数 k，请编写一个函数，将字符串中的后面 k 个字符移到字符串的前面，实现字符串的右旋转操作。
例如，对于输入字符串 "abcdefg" 和整数 2，函数应该将其转换为 "fgabcde"。*/
class solutionmaka55{
    public String rightReverseString(String s, int k) {
        char[] res = s.toCharArray();
        reverseLeftToRight(res, 0, res.length-1);
        reverseLeftToRight(res, 0, k-1);
        reverseLeftToRight(res, k, res.length-1);

        return String.valueOf(res);
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
}
