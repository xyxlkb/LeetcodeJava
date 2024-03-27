import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = {4,2,8,1,5,10,23,0};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }

    public void sort(int[] a,int low,int high){
        if(low < high){
            int pivotpos = partition(a,low,high);
            sort(a,low,pivotpos-1);
            sort(a,pivotpos+1,high); //这里pivotpos位置不需要再排了！因为这已经是最终位置了
        }
    }

    int partition(int[] a,int low,int high){ //讲从low到high的第一个放到最终位置
        int pivot = a[low];
        while(low < high){
            while (low<high && a[high]>=pivot) high--;  //在右边找到一个比pivot小的，注意这里要等于号
            a[low] = a[high]; //low的值已经用pivot记录，相当于空出来了，用比pivot小的填上
            while(low<high && a[low]<=pivot) low++;  //在左边找到一个比pivot大的
            a[high] = a[low];
        }
        a[low] = pivot;
        return low; // 返回pivot被放在的最终位置
    }
}