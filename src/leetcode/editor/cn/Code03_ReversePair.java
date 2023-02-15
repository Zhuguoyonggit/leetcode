package leetcode.editor.cn;

public class Code03_ReversePair {
    public int reverPairNumber(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return process(arr, 0, arr.length - 1);
    }

    public int process(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = l + ((l + r) >> 1);
        return process(arr, l, mid) + process(arr, mid + 1, r) + merge(arr, l, r, mid);
    }

    public int merge(int[] arr, int l, int r, int mid) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int res = 0;
        int p1 = l;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= r) {
            res += arr[p1] > arr[p2] ? r - p2 + 1 : 0;
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2];
        }
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        for (int j = 0; j < help.length; j++) {
            arr[l++] = help[j];
        }
        return res;
    }
}
