package leetcode.editor.cn;

public class Code04_RadixSort {

    // only for no-negative value
    public static void radixSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int digit = getMaxDigit(arr);
        redix(arr, 0, arr.length - 1, digit);
    }

    public static int getMaxDigit(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(arr[i], max);
        }
        int ans = 0;
        while (max > 0) {
            max /= 10;
            ans++;
        }
        return ans;
    }

    public static void redix(int[] arr, int l, int r, int digit) {
        int radix = 10;
        int[] help = new int[r - l + 1];
        for (int i = 0; i < digit; i++) {// 有多少位就进出多少位
            // 用count记录各个位置的数据
            int[] count = new int[radix];
            for (int j = l; j <=r; j++) {
                count[getDigit(arr[j], i)]++;
            }
            // 算出count各位置之前有多少的数目
            for (int j = l; j < r; j++) {
                count[j] = count[j - 1] + count[j];
            }
            // 从后往前进行遍历到help数组中
            for (int j = r; j >= l; j--) {
                // 注意这里是要减一，从第零位开始
                help[count[getDigit(arr[j], i)] - 1] = arr[j];
            }
            // 复制回原数组
            for (int j = l; j <= r; j++) {
                arr[j] = help[j];
            }
        }
    }

    public static int getDigit(int i, int j) {
        return (i / (int) (Math.pow(10, j)) % 10);
    }
}
