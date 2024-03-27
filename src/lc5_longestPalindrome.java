public class lc5_longestPalindrome {
    public static void main(String[] args) {
        String s = "cbbd";
        Solution5 so = new Solution5();
        System.out.println(so.longestPalindrome(s));
    }
}

class Solution5 {
    public String longestPalindrome(String s) {
        int maxLength = 0;
        String res = "";
        if (s==null || s.length()<2)
            return s;
        for (int i=0; i<s.length(); i++) {
            int len1 = expand(s, i, i);
            int len2 = expand(s, i, i+1);
            int len = Math.max(len1, len2);
            if (len > maxLength) {
                maxLength = len;
                if (len%2 == 0)
                    res = s.substring(i-len/2+1,i+len/2+1);
                else
                    res = s.substring(i-len/2,i+len/2+1);
            }
        }
        return res;
    }

    public int expand(String s, int left, int right) {
        if (right >= s.length())
            return 0;
        if (left < 0)
            return 0;

        while (left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)) {
            left--;
            right++;
        }

        return right-left-1;
    }
}