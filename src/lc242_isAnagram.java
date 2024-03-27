public class lc242_isAnagram {
    public static void main(String[] args) {
        Solution242 so = new Solution242();
        String s = "hello";
        String t = "lloehd";
        System.out.println(so.isAnagram(s,t));
    }
}

class Solution242 {
    public boolean isAnagram(String s, String t) {
        int[] countS = new int[26];
        int[] countT = new int[26];
        for (int i=0; i<26; i++) {
            countT[i] = 0;
            countS[i] = 0;
        }

        int len = s.length();
        for (int i=0; i<len; i++) {
            char ch = s.charAt(i);
            countS[ch-'a']++;
        }
        len = t.length();
        for (int i=0; i<len; i++) {
            char ch = t.charAt(i);
            countT[ch-'a']++;
        }

        for (int i=0; i<26; i++) {
            if (countS[i] != countT[i])
                return false;
        }
        return true;
    }
}