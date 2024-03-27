import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] array = {4,2,8,1,5,10,23,0};
        MergeSort mergeSort = new MergeSort();
        System.out.println(Arrays.toString(mergeSort.sort(array)));
    }

    public int[] sort(int[] a){ //归并排序操作,给出数组，左端点，右端点
        int len = a.length;
        if(len<2)
            return a;
        int mid = len/2;
        int[] left = Arrays.copyOfRange(a,0,mid);
        int[] right = Arrays.copyOfRange(a,mid,len);

//        System.out.println("left  "+Arrays.toString(left));
//        System.out.println("right  "+Arrays.toString(right));

        return merge(sort(left),sort(right));
    }

    public int[] merge(int[] left, int[] right){  //把两个已经有序的数组结合成一个大数组并返回
        int[] result = new int[left.length+right.length];
        int i=0,j=0,k=0;
        while(i<left.length && j<right.length){
            if(left[i] < right[j])
                result[k++] = left[i++];
            else
                result[k++] = right[j++];
        }
        while(i<left.length)
            result[k++] = left[i++];
        while(j<right.length)
            result[k++] = right[j++];

//        System.out.println(Arrays.toString(result));
        return result;
    }
}