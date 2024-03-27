import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {4,2,8,1,5,10,23,0};
        BubbleSort bubbleSort = new BubbleSort();
        System.out.println(Arrays.toString(bubbleSort.solution(array)));
    }

    public int[] solution(int[] a){
        int n = a.length;
        for(int i=0;i<n;i++){
            for(int j=n-1;j>i;j--){
                if(a[j] < a[i])
                    swap(a,i,j);
            }
        }
        return a;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
