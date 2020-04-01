package go.com.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Algorith {
    public static void main(String[] args) {
        int[] array = {49, 38, 65, 97, 76, 13, 2749, 38, 65, 97, 76, 13, 27, 49, 38, 65, 97, 76, 13, 2749, 38, 65, 97, 76, 13, 27};
        int[] a2 = {11, 222,2, 3, 14, 5, 38, 1};
//        nonRecrutSort(a2);
        sort(a2, 0, a2.length-1);
        System.out.println(Arrays.toString(a2));
        System.out.println(binarySearch(a2, 38));
    }

    /**
     * 快速排序-递归
     *
     * @param arr
     * @param _low
     * @param _high
     */
    public static void sort(int[] arr, int _low, int _high) {
        //当前一次计算 start
        int low = _low;
        int high = _high;

        if (low >= high)
            return;
        int temp = arr[low];
        while (high != low) {
            while (arr[high] >= temp && high > low)
                high--;
            arr[low] = arr[high];
            while (arr[low] <= temp && high > low)
                low++;
            arr[high] = arr[low];
        }
        arr[low] = temp;
        //当前一次计算 end

        sort(arr, _low, low - 1);  // 在计算从最左侧到基于上面基准量-1
        sort(arr, high + 1, _high);  // 在基于上面基准量+1，在计算(在计算和第一个递归意思一样)
    }

    /**
     * 二分法查找
     *
     * @param arr
     * @param item
     * @return
     */
    public static int binarySearch(int[] arr, int item) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (item > arr[mid]) {
                low = mid + 1;
            } else if (item < arr[mid]) {
                high = mid - 1;
            } else
                return mid;
        }
        return -1;
    }
}
