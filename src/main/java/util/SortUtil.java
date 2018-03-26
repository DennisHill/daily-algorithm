package util;



import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Random;

/**
 *  排序工具类
 * @author  Hu Hongtao
 * @date  2018/3/26 20:08
 **/
public class SortUtil {

    private SortUtil() {
    }

    /**
     * 生成随机的整形数组
     * @param count
     * @param start
     * @param end
     * @return
     */
    public static Integer[] generateRandomArray(int count, int start, int end) {
        Integer[] arr = new Integer[count];
        Random rand = new Random();
        for (int i = 0; i < count; i++) {
            arr[i] = rand.nextInt(end - start + 1) + start;
        }
        return arr;
    }


    /**
     * 生成近乎排序的整形数组
     * @param n 数组长度
     * @param swapTimes 交换次数
     * @return
     */
    public static Integer[] generateNearlyOrderedArray(int n, int swapTimes) {
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        Random random = new Random();
        for (int i = 0; i < swapTimes; i++) {
            int x = random.nextInt(n - 1);
            int y = random.nextInt(n - 1);
            swap(arr, x, y);
        }
        return arr;
    }


    /**
     * 计算各个排序算法消耗时间
     * @param sortName 排序的名称
     * @param clazz 排序的class
     * @param methodName 排序的调用方法
     * @param arr
     * @throws Exception
     */
    public static <T extends Comparable<? super T>> void testSort(String sortName, Class clazz, String methodName, T[] arr) throws Exception {
        Method method = clazz.getMethod(methodName, Comparable[].class);
        long startTime = System.currentTimeMillis();
        //调用静态方法无需实例
        method.invoke(null, new Object[] { arr });
        long endTime = System.currentTimeMillis();
        System.out.println(sortName + ":" + (endTime - startTime) / 1000.00 + "s");
    }


    /**
     * 复制数组
     * @param t
     * @return
     */
    public static <T extends Comparable<? super T>> T[] copyArray(T[] t) {
        T[] arr = (T[]) Array.newInstance(t.getClass().getComponentType(), t.length);
        System.arraycopy(t, 0, arr, 0, t.length);
        return arr;
    }


    /**
     * 打印数组
     * @param arr
     * @param <T>
     */
    public static <T> void printArray(T[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 交换数组的两个元素的顺序
     * @param arr
     * @param a
     * @param b
     */
    public static <T> void swap(T[] arr, int a, int b) {
        T tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

}
