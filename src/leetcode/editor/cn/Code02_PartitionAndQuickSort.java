package leetcode.editor.cn;

import java.util.Arrays;

public class Code02_PartitionAndQuickSort {
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int partition(int[] arr, int l, int r) {
        if (l > r) {
            return -1;
        }
        if (l == r) {
            return l;
        }
        int less = l - 1;
        int index = l;
        int more = r;
        while (index < more) {
            if (arr[index] <= arr[more]) {
                // 这里不需要index++，if的外面是有的
                swap(arr, index, ++less);
            }
            index++;
        }
        swap(arr, ++less, more);
        return less;
    }

    public static int[] netherlandsFlag(int[] arr, int l, int r) {
        if (l > r) {
            return new int[]{-1, -1};
        }
        if (l == r) {
            return new int[]{l, r};
        }
        int less = l - 1;
        int more = r;
        int index = l;
        while (index < more) {
            if (arr[index] == arr[more]) {
                index++;
            } else if (arr[index] < arr[more]) {
                swap(arr, index++, ++less);
            } else {
                swap(arr, index, --more);
            }
            // 这时候的more是指向index的下一，刚好可以把最后的值给交换过来
            swap(arr, more, r);
        }
        return new int[]{less + 1, more};
    }
    public static int[] quickSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        process(arr, 0, arr.length - 1);
        return arr;
    }
    public static int[] quickSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        process1(arr, 0, arr.length - 1);
        return arr;
    }
    public static void process1(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int[] m = netherlandsFlag(arr, l, r);
        process1(arr, l, m[0] - 1);
        process1(arr, m[1] + 1, r);
    }
    public static void process(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int m = partition(arr, l, r);
        process(arr, l, m - 1);
        process(arr, m + 1, r);
    }

    public static void main(String[] args) {
        int[] ints = {2,1,3,4,5,1,0,0,0,6,7,9,0,8};
        System.out.println(Arrays.toString(quickSort1(ints)));
        System.out.println(Arrays.toString(quickSort2(ints)));
    }
}
