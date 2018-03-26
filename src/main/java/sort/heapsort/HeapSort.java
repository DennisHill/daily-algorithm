package sort.heapsort;

import util.SortUtil;

/**
 * 堆排序
 * @author Hu Hongtao
 * date 2018/3/26 20:03
 */
public class HeapSort {

    public static <T extends Comparable> void heapSort(T[] arr) {
        int count = arr.length;
        // 非叶子节点
        for (int i = (count - 1) / 2; i >= 0; i --) {
            shiftDown(arr, count, i);
        }
        for (int i = count - 1; i > 0; i --) {
            // 交换最大值元素至队尾
            SortUtil.swap(arr, i, 0);
            shiftDown(arr, i, 0);
        }

    }

    /**
     * 调整最大堆结构
     * @param arr
     * @param count
     * @param index
     */
    private static <T extends Comparable> void shiftDown(T[] arr, int count, int index) {
        // 存在左节点
        while (2 * index + 1 < count) {
            int j = 2 * index + 1;
            // 存在右节点并比较左右节点
            if (j + 1 < count && arr[j].compareTo(arr[j + 1]) < 0) {
                j += 1;
            }
            // 比较父节点子节点大小
            if (arr[index].compareTo(arr[j]) >= 0) {
                break;
            }
            SortUtil.swap(arr, index, j);
            index = j;
        }
    }

    public static void main(String[] args) {
        int count = 10;
        Integer[] arr = SortUtil.generateRandomArray(count, 1, 10000);
        SortUtil.printArray(arr);
        heapSort(arr);
        SortUtil.printArray(arr);
    }

}
