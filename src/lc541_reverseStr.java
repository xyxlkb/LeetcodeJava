public class lc541_reverseStr {
    public static void main(String[] args) {
        Solution541 so = new Solution541();
        String s = "abcdefg";
        so.reverseStr(s,3);
//        System.out.println(so.reverseStr(s,2));
    }
}
class Solution541 {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray(); // 变成字符数组方便操作
        int len = s.length();
        for (int i=0; i<len;) {
            int left = i; // 记录这一轮的开始
            i += k;
            int right = i-1;
            if (i >= len)
                right = len-1; // right表示翻转的右侧，如果到头了，就只反转到最后一个
            while (left < right) {
                char ch = chars[left];
                chars[left] = chars[right];
                chars[right] = ch;
                left++;
                right--;
            }
            i += k;
        }
        System.out.println(chars);
        return String.valueOf(chars);
    }
}
