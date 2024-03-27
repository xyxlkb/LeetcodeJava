public class lc59_generateMatrix {
    public static void main(String[] args) {
        Solution59 so = new Solution59();
        int n = 4;
        int[][] a = so.generateMatrix(n);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++)
                System.out.print(a[i][j]);
            System.out.println();
        }

    }
}
class Solution59 {    public int[][] generateMatrix(int n) {
    int direction = 0; // 表示前进方向 0→ 1↓ 2← 3↑ 最开始是向右
    int [][] res = new int[n][n];
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++)
            res[i][j] = 0; // 先给数组清零
    }
    int i = 0;
    int j = 0; // 表示行和列
    for(int val=1; val<=n*n; val++){
        res[i][j] = val;
        if(direction == 0) { // 现在是向右走
            if(j == n-1 || res[i][j+1]!=0) { //走到头了或者右边已经填过了就向下走
                i++;
                direction = 1;
            }
            else
                j++;
        }
        else if(direction == 1) { // 现在是向下走
            if(i == n-1 || res[i+1][j]!=0){ // 走到头了或者下面已经填过了，就向左走
                j--;
                direction = 2;
            }
            else
                i++;
        }
        else if(direction == 2) { // 现在是向左走
            if(j==0 || res[i][j-1]!=0){ // 走到头或者左边填过了，就向上走
                i--;
                direction = 3;
            }
            else
                j--;
        }
        else if(direction == 3) { // 现在是向上走
            if(i==0 || res[i-1][j]!=0){ // 走到头了或者上面填过了，就向右走
                j++;
                direction = 0;
            }
            else
                i--;
        }
    }

    return res;
}
}