import java.net.SocketTimeoutException;
import java.util.HashSet;
import java.util.Set;

public class lc202_isHappy {
    public static void main(String[] args) {
        Solution202 so = new Solution202();
        System.out.println(so.isHappy(2));
    }
}
/*
* 编写一个算法来判断一个数 n 是不是快乐数。
「快乐数」 定义为：
对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
如果这个过程 结果为 1，那么这个数就是快乐数。
如果 n 是 快乐数 就返回 true ；不是，则返回 false 。*/
class Solution202 {
    // 如果不是快乐数，就会无限循环，所以每次出现一个数就记录到set里，如果重复出现了就判断不是，出现了1就是
    // 当我们遇到了要快速判断一个元素是否出现集合里的时候，就要考虑哈希法了。
    public boolean isHappy(int n) {
        Set<Integer> flag = new HashSet<>();
        while (n != 1) {
            if (flag.contains(n)) // 如果n出现过了就不是快乐数
                return false;
            flag.add(n);
            n = nextHappyNum(n);
        }
        return true;
    }
    public int nextHappyNum(int n) {
        int res = 0;
        while (n > 0) {
            int t = n % 10;
            res += t*t;
            n = n / 10;
        }
        return res;
    }
}