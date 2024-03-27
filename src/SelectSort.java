import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[] array = {4,2,8,1,5};
        SelectSort selectSort = new SelectSort();
        selectSort.solution(array);
        System.out.println(Arrays.toString(array));
    }

    public void solution(int[] array){
        int len = array.length;
        for(int i=0;i<len;i++){
            int min = array[i];
            int pos = i;
            for(int j=i+1;j<len;j++)
                if(array[j] < min){
                    min = array[j];
                    pos = j;
                }
            swap(array,i,pos);
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
