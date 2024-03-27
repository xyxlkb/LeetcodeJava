import java.util.LinkedList;
import java.util.List;

public class lc49_groupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        Solution49 so = new Solution49();
        System.out.println(so.groupAnagrams(strs));
    }
}

class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new LinkedList<>();
        if (strs == null)
            return res;

        int n = strs.length;
        boolean[] flag= new boolean[n];
        for (int i=0; i<n; i++) {
            flag[i] = false;
        }

        for (int i=0; i<n; i++) {
            if (flag[i])
                continue;

            String curStr = strs[i];
            List<String> curGroup = new LinkedList<>(); // 新建字符串组
            curGroup.add(curStr);
            flag[i] = true;
            int[] curStrFlag = new int[27];
            for (int k=0; k<curStr.length(); k++) {
                curStrFlag[curStr.charAt(k)-'a']++;
            }

            for (int j=i+1; j<n; j++) {
                if (flag[j])
                    continue;
                String comStr = strs[j];
                int[] comStrFlag = new int[27];
                for (int k=0; k<comStr.length(); k++) {
                    comStrFlag[comStr.charAt(k)-'a']++;
                }
                if (isSameArray(curStrFlag, comStrFlag)) {
                    curGroup.add(comStr);
                    flag[j] = true;
                }
            }
            res.add(curGroup);
        }

        return res;
    }

    public boolean isSameArray(int[] a, int[] b) {
        if (a.length != b.length)
            return false;
        for (int i=0; i<a.length; i++)
            if (a[i] != b[i])
                return false;
        return true;
    }

}