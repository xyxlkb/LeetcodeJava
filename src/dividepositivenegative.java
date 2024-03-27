public class dividepositivenegative {
    public static void rearrangeArray(int[] arr) {
        int positiveInsertIndex = 0; // 初始化正数应该插入的位置为数组开头

        // 遍历数组
        for (int current = 0; current < arr.length; current++) {
            if (arr[current] < 0) { // 如果当前元素是负数
                // 将负数与positiveInsertIndex指向的位置的元素交换
                int temp = arr[current];
                arr[current] = arr[positiveInsertIndex];
                arr[positiveInsertIndex] = temp;

                // 更新positiveInsertIndex指针
                positiveInsertIndex++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {-1, 3, -2, 2, -4, 5, 6, -7};
        rearrangeArray(arr);

        // 打印重新排列后的数组
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
