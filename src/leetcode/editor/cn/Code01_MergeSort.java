package leetcode.editor.cn;

public class Code01_MergeSort {
    public void mergeSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    public void process(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int middle = l + ((l + r) >> 2);
        process(arr, l, middle);
        process(arr, middle + 1, r);
        merge(arr, l, r, middle);
    }

    public void merge(int[] arr, int l, int r, int mid) {
        int[] help = new int[r - l + 1];
        int p1 = l;
        int p2 = mid + 1;
        int i= 0;
        while (p1 <= mid && p2 <= r) {
            help[i] = arr[p1] < arr[p2] ? arr[p1] : arr[p2];
            i++;
            p1++;
            p2++;
        }
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        for (int j = 0; j < help.length; j++) {
            arr[j + l] = help[j];
        }
    }

    // 非递归实现
    public void mergeSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int mergeSize = 1;
        int n = arr.length;
        while (mergeSize < n) {
            int l = 0;
            while (l < n) {
                int m = l + mergeSize - 1;
                if (m >= n) {
                    break;
                }
                int r = Math.min(mergeSize, n - m - 1) + m;
                merge(arr, l, r, m);
                l = r + 1;
            }
            if (mergeSize > n / 2) {
                break;
            }
            mergeSize <<= 1;
        }
    }
}
