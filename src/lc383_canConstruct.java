import java.util.ArrayList;
import java.util.Arrays;

public class lc383_canConstruct {
    public static void main(String[] args) {
        String a = "hello";
        String b = "helol";
        Solution383 so = new Solution383();
        System.out.println(so.canConstruct(a,b));

    }
}
/*给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
如果可以，返回 true ；否则返回 false 。
magazine 中的每个字符只能在 ransomNote 中使用一次。
1 <= ransomNote.length, magazine.length <= 105
ransomNote 和 magazine 由小写英文字母组成*/
class Solution383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        int[] flag = new int[26];
        Arrays.fill(flag, 0);
        int len = magazine.length();
        for (char ch : magazine.toCharArray())
            flag[ch - 'a']++;

        len = ransomNote.length();
        for (char ch : ransomNote.toCharArray()) {
            flag[ch - 'a']--;
            if (flag[ch - 'a'] < 0)
                return false;
        }

        return true;
    }
}
